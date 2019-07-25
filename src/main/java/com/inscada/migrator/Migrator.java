package com.inscada.migrator;

/**
 *
 * @author fadime
 */
public interface Migrator {

    void transferEventLogs();

    void transferFiredAlarms();

    void transferVariableValues();

    boolean testPostgresqlConnection(ConnectionInfo connectionInfo);

    boolean testInfluxDbConnection(ConnectionInfo connectionInfo);
}
