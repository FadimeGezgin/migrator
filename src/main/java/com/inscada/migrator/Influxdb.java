package com.inscada.migrator;

import java.sql.*;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;


public class Influxdb implements Migrator{

    private InfluxDB influxdbConnection;
    private Connection postgresqlConnection;

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
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean influxdbConnect(String host, Integer port, String dbName,
            String username, Integer password) {

        String url = "http://" + host + ":" + port;

        try {
            this.influxdbConnection = InfluxDBFactory.connect(url, username, url);
            System.out.println("Connected to influxdb.");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public void eventLogs() {
        throw new UnsupportedOperationException("Not supported yet."); 
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
