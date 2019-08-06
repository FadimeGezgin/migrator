package com.inscada.migrator;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.TokenType;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBException;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import sun.rmi.runtime.Log;

public class MigratorImpl implements Migrator {

    private final static Logger logger = Logger.getLogger(MigratorImpl.class.getName());

    private static final String EVENT_LOG = "event_log";

    private static final String FIRED_ALARM = "fired_alarm";

    private static final String READ_VARIABLE_NUM = "read_variable_num";

    private final App app;

    private InfluxDB influxdbConnection;
    private Connection postgresqlConnection;
    List<Point> e_points = new ArrayList<>();
    List<Point> f_points = new ArrayList<>();
    List<Point> r_points = new ArrayList<>();
    private Map<Integer, String> projectIdNameMap = new ConcurrentHashMap<>();
    private Map<Integer, String> variableIdNameMap = new ConcurrentHashMap<>();
    private final String postgresqlHost;
    private final Integer postgresqlPort;
    private final String postgresqlnameDB;
    private final String postgresqlUserName;
    private final String postgresqlUserPassword;
    private final String influxdbHost;
    private final Integer influxdbPort;
    static int counter = 0;
    static int counter2 = 0;
    static int counter3 = 0;
    static int batchsize;
    static int offset = 0;
    private int Count;
    static int a=0;

    MigratorImpl(App app) {
        this.app = app;
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
            influxdbConnection.enableBatch();

            return true;
        } catch (Exception e) {
            System.out.println("Not connected.");
            return false;
        }
    }

    public String getVariableName(Integer variableId) {
        String variableName = null;

        if (variableIdNameMap.containsKey(variableId)) {
            variableName = variableIdNameMap.get(variableId);
        } else {
            try {
                Statement st = postgresqlConnection.createStatement();
                ResultSet rs = st.executeQuery("SELECT variable_name FROM variable WHERE v_id = " + variableId);
                while (rs.next()) {
                    variableName = rs.getString(1);
                }

                variableIdNameMap.put(variableId, variableName);

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return variableName;
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

    public int findNameCount(String tableName) {
        switch (tableName) {
            case EVENT_LOG:
                return findCount(EVENT_LOG);
            case FIRED_ALARM:
                return findCount(FIRED_ALARM);
            case READ_VARIABLE_NUM:
                return findCount(READ_VARIABLE_NUM);
            default:
                return -1;
        }
    }

    public int findCount(String tableName) {
        int count = -1;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = String.format("select count(*) from %s", tableName);
            st = this.postgresqlConnection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "Error while closing result set", ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "Error while closing statement", ex);
                }
            }
        }
    }

    @Override
    public void threadProduce(int nThreads, int nBatchSize, final String tableName, final String startTime, final String endTime) {
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        
        batchsize = nBatchSize;
        final int batch = nBatchSize;
        
        try {
            Statement st1 = postgresqlConnection.createStatement();
            String format = String.format("select count(*) from %s  WHERE dttm BETWEEN '%s' AND '%s' ", tableName, startTime, endTime);
            ResultSet rs2 = st1.executeQuery(format);
            
            while (rs2.next()) {
                Count = rs2.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MigratorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        int temp = Count / batch;
     
        for ( int i = 0; i < temp; i++) {
            executorService.execute(new Runnable() {
                
           
                @Override
                public void run() {
                    a++;
                    if ("event_log".equals(tableName)) {
                        
                        System.out.println("thread no: " + a);
                        System.out.println("batch no: " + batchsize);
                        transferEventLogs(startTime, endTime, batchsize, offset);
                        offset = offset + batch;
                        batchsize = batchsize + batch;

                    } else if ("fired_alarm".equals(tableName)) {

                    } else {

                    }
                }
            });
        }
        executorService.shutdown();
    }

    @Override
    public void transferEventLogs(final String startE, final String endE, int limit, int offset) {
        final int total = findNameCount(EVENT_LOG);
        
        try {
            Statement st = postgresqlConnection.createStatement();
            String query = String.format("SELECT * FROM event_log  WHERE dttm BETWEEN '%s' AND '%s' ORDER BY dttm LIMIT %d OFFSET %d ", startE, endE, limit, offset);
            ResultSet rs = st.executeQuery(query);
            Statement st1 = postgresqlConnection.createStatement();
            String format = String.format("select count(*) from event_log  WHERE dttm BETWEEN '%s' AND '%s' ", startE, endE);
            ResultSet rs2 = st1.executeQuery(format);
            
            while (rs2.next()) {
                Count = rs2.getInt(1);
            }
            
            while (rs.next()) {
                counter++;
                int progress = (int) (100.0 * counter / Count);
                app.setProgress(progress);

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

                Point point = Point.measurement(EVENT_LOG)
                        .time(ts.getTime(), TimeUnit.MILLISECONDS)
                        .tag(tags).addField("msg", msg).build();
                e_points.add(point);
            }

            BatchPoints batchPoints = BatchPoints
                    .database("inscada")
                    .retentionPolicy("event_log_rp")
                    .points(e_points)
                    .build();
            influxdbConnection.write(batchPoints);
            System.out.println("Batch written.");
            e_points.clear();
            System.out.println("Data is written.");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void transferFiredAlarms(String startF, String endF, int limit, int offset) {
        final int total = findNameCount(FIRED_ALARM);

        try {
            Statement st1 = postgresqlConnection.createStatement();
            String query1 = String.format("SELECT * FROM fired_alarm WHERE on_dttm BETWEEN '%s' AND '%s' ", startF, endF);
            ResultSet rs1 = st1.executeQuery(query1);

            while (rs1.next()) {
                counter2++;
                int progress = (int) (100.0 * counter2 / total);
                app.setProgress3(progress);

                Integer alarmId = rs1.getInt(2);
                Integer projectId = rs1.getInt(3);
                String projectName = getProjectName(projectId);
                String status = rs1.getString(4);
                Timestamp onDttm = rs1.getTimestamp(5);
                Timestamp offDttm = rs1.getTimestamp(6);
                Timestamp acknowledge = rs1.getTimestamp(7);
                String acknowledger = rs1.getString(8);

                Map<String, String> tags = new HashMap<String, String>();
                tags.put("project_id", projectId.toString());
                tags.put("project", projectName);
                tags.put("alarm_id", alarmId.toString());

                Point point = Point.measurement(FIRED_ALARM)
                        .time(onDttm.getTime(), TimeUnit.MILLISECONDS)
                        .tag(tags).addField("status", status).addField("off_time", offDttm.toString())
                        .addField("ack_time", acknowledge.toString())
                        .addField("ack_by", acknowledger).build();
                f_points.add(point);
            }
            BatchPoints batchPoints = BatchPoints
                    .database("inscada")
                    .retentionPolicy("fired_alarm_rp")
                    .points(f_points)
                    .build();
            influxdbConnection.write(batchPoints);
            System.out.println("Batch written.");
            f_points.clear();
            System.out.println("Data is written.");
        } catch (SQLException ex) {
            Logger.getLogger(MigratorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void transferVariableValues(String startV, String endV, int limit, int offset) {
        final int total = findNameCount(READ_VARIABLE_NUM);

        try {
            Statement st2 = postgresqlConnection.createStatement();
            String query2 = String.format("SELECT * FROM read_variable_num WHERE read_dttm BETWEEN '%s' AND '%s' ", startV, endV);
            ResultSet rs2 = st2.executeQuery(query2);
            Statement st3 = postgresqlConnection.createStatement();
            ResultSet rs3 = st3.executeQuery("SELECT * FROM project LIMIT 100");

            while (rs2.next() && rs3.next()) {
                counter3++;
                int progress = (int) (100.0 * counter3 / total);
                app.setProgress2(progress);

                Integer projectId = rs3.getInt(2);
                String projectName = getProjectName(projectId);
                Integer variableId = rs2.getInt(1);
                String name = getVariableName(variableId);
                Timestamp time = rs2.getTimestamp(2);
                Float value = rs2.getFloat(3);

                Map<String, String> tags = new HashMap<String, String>();
                tags.put("project_id", projectId.toString());
                tags.put("project", projectName);
                tags.put("variable_id", variableId.toString());
                tags.put("name", name);

                Point point = Point.measurement("variable_value")
                        .time(time.getTime(), TimeUnit.MILLISECONDS)
                        .tag(tags).addField("value", value).build();
                r_points.add(point);
            }
            BatchPoints batchPoints = BatchPoints
                    .database("inscada")
                    .retentionPolicy("variable_value_rp")
                    .points(r_points)
                    .build();
            influxdbConnection.write(batchPoints);
            System.out.println("Batch written.");
            r_points.clear();
            System.out.println("Data is written.");
        } catch (SQLException ex) {
            Logger.getLogger(MigratorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
