package com.inscada.migrator;

import java.sql.*;


public class Influxdb implements Migrator{
    
    public static void main(String args[]) {
        Connection postgresConnection = null;
       
        Statement stmt = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.postgresql.Driver");
            postgresConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "1234");
            stmt = postgresConnection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_log;");
            while (rs.next()) {
                int project_id = rs.getInt("project_id");
                String activity = rs.getString("activity");
                String msg = rs.getString("msg");
                String log_severity = rs.getString("log_severity");
                int log_id=rs.getInt("log_id");
                System.out.println("PROJECT ID = " + project_id);
                System.out.println("ACTIVITY = " + activity);
                System.out.println("MSG = " + msg);
                System.out.println("LOG SEVERITY = " + log_severity);
                System.out.println("LOG ID = " + log_id);
                System.out.println();
            }
            rs.close();
            stmt.close();
            postgresConnection.close();

            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }

    @Override
    public void eventLogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void firedAlarms() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void variableValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
