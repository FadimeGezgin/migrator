package com.inscada.migrator;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBException;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;

public class MigratorImpl implements Migrator {

    private InfluxDB influxdbConnection;
    private Connection postgresqlConnection;
    List<Point> points = new ArrayList<>();
    private Map<Integer, String> projectIdNameMap = new ConcurrentHashMap<>();

    private final String postgresqlHost;
    private final Integer postgresqlPort;
    private final String postgresqlnameDB;
    private final String postgresqlUserName;
    private final String postgresqlUserPassword;
    private final String influxdbHost;
    private final Integer influxdbPort;

    MigratorImpl() {
        this.postgresqlHost = null;
        this.postgresqlPort = null;
        this.postgresqlnameDB = null;
        this.postgresqlUserName = null;
        this.postgresqlUserPassword = null;
        this.influxdbHost = null;
        this.influxdbPort = null;
    }

    public InfluxDB getInfluxdbConnection() {
        return influxdbConnection;
    }

    public Connection getPostgresqlConnection() {
        return postgresqlConnection;
    }

    public String getProjectName(Integer projectId) {
        String projectName = null;

        if (projectIdNameMap.containsKey(projectId)) {
            projectName = projectIdNameMap.get(projectId);

        } else {
            try {
                Statement st = postgresqlConnection.createStatement();
                ResultSet rs = st.executeQuery("SELECT project_name"
                        + " FROM project"
                        + " WHERE p_id = "
                        + projectId);
                while (rs.next()) {
                    projectName = rs.getString(1);
                }

                projectIdNameMap.put(projectId, projectName);

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return projectName;
    }

    @Override
    public void transferEventLogs() {
        try {
            int offset = 0;

            influxdbConnection.enableBatch();

            Statement st = this.postgresqlConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT *"
                    + "  FROM event_log"
                    + " ORDER BY dttm"
                    + " LIMIT 20 OFFSET " + offset);

            while (rs.next()) {
                Integer projectId = rs.getInt(6);
                String projectName = getProjectName(projectId);
                String activity = rs.getString(1);
                String msg = rs.getString(2);
                Timestamp ts = rs.getTimestamp(3);
                String log_severity = rs.getString(4);

                Map<String, String> tags = new HashMap<String, String>();
                tags.put("project", projectName);
                tags.put("activity", activity);
                tags.put("severity", log_severity);

                Point point = Point.measurement("event_log")
                        .time(ts.getTime(), TimeUnit.MILLISECONDS)
                        .tag(tags).addField("msg", msg).build();
                points.add(point);
                Thread.sleep(1);
            }

            BatchPoints batchPoints = BatchPoints
                    .database("inscada")
                    .retentionPolicy("event_log_rp")
                    .points(points)
                    .build();
            influxdbConnection.write(batchPoints);
            System.out.println("Batch written.");
            points.clear();

            System.out.println("Data is written.");
            influxdbConnection.disableBatch();

        } catch (InterruptedException | SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean testPostgresqlConnection(ConnectionInfo postgresqlConnectionInfo) {

        String url = "jdbc:postgresql://" + postgresqlConnectionInfo.getHost() + ":" + postgresqlConnectionInfo.getPort()
                + "/" + postgresqlConnectionInfo.getDbname();

        try {
            this.postgresqlConnection = DriverManager.getConnection(url, postgresqlConnectionInfo.getUsername(),
                    postgresqlConnectionInfo.getPassword().toString());
            System.out.println("Connected to postgresql.");
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean testInfluxDbConnection(ConnectionInfo influxdbcConnectionInfo) {

        String url = "http://" + influxdbcConnectionInfo.getHost() + ":" + influxdbcConnectionInfo.getPort();

        try {
            this.influxdbConnection = InfluxDBFactory.connect(url);
            System.out.println("Connected to influxdb.");
            return true;
        } catch (Exception e) {
            System.out.println("Not connected.");
            return false;
        }
    }

    @Override
    public void transferFiredAlarms() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void transferVariableValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
