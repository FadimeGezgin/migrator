package com.inscada.migrator;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class Influxdb implements Migrator {

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
    //private Influxdb InfluxDBFactory;

    public Influxdb(String postgresqlHost, Integer postgresqlPort, String postgresqlnameDB, String postgresqlUserName, String postgresqlUserPassword, String influxdbHost, Integer influxdbPort) {
        this.postgresqlHost = postgresqlHost;
        this.postgresqlPort = postgresqlPort;
        this.postgresqlnameDB = postgresqlnameDB;
        this.postgresqlUserName = postgresqlUserName;
        this.postgresqlUserPassword = postgresqlUserPassword;
        this.influxdbHost = influxdbHost;
        this.influxdbPort = influxdbPort;
    }

    Influxdb() {
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

    public void setInfluxdbConnection(InfluxDB influxdbConnection) {
        this.influxdbConnection = influxdbConnection;
    }

    public Connection getPostgresqlConnection() {
        return postgresqlConnection;
    }

    public void setPostgresqlConnection(Connection postgresqlConnection) {
        this.postgresqlConnection = postgresqlConnection;
    }

    public boolean postgresqlConnect(String host, Integer port, String dbName,
            String username, Integer password) {

        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;

        try {
            this.postgresqlConnection = DriverManager.getConnection(url, username,
                    password.toString());
            System.out.println("Connected to postgresql.");
            eventLogs();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean influxdbConnect(String host, Integer port) {

        String url = "http://" + host + ":" + port;

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
    public void eventLogs() {

        int offset = 0;

        try {

            Statement stmt = postgresqlConnection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM event_log;");

            while (true) {
                //Statement statement = postgresqlConnection.createStatement();
                //ResultSet resultSet = statement.executeQuery("SELECT * FROM event_log ORDER BY project_id LIMIT 10 OFFSET " + offset);
                //System.out.println(resultSet);

                while (resultSet.next()) {
                    Integer projectId = resultSet.getInt(1);
                   // String projectName = getProjectName(projectId); 
                    String activity = resultSet.getString(2);
                    String msg = resultSet.getString(3);
                    Timestamp tsm = resultSet.getTimestamp(4);
                    String log_severity = resultSet.getString(5);
                    Integer log_id = resultSet.getInt(6);
                    
                    
                    Map<String, String> chr = new HashMap<String, String>();
                    //chr.put("project", projectId);
                    chr.put("project_id", projectId.toString());
                    chr.put("activity", activity);
                    chr.put("msg", msg.toString());
                    chr.put("dttm", tsm.toString());
                    chr.put("severity", log_severity);
                    chr.put("log id", log_id.toString());
                    
                    System.out.println(chr);

                  /*  System.out.println("PROJECT ID = " + projectId);
                    System.out.println("ACTİVİTY = " + activity);
                    System.out.println("MSG = " + msg);
                    System.out.println("DTTM = " + tsm);
                    System.out.println("LOG SEVERİTY = " + log_severity);
                    System.out.println("LOG ID = " + log_id);*/
                }

            }

        } catch (Exception e) {
        }

    }

    @Override
    public void firedAlarms() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void variableValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
