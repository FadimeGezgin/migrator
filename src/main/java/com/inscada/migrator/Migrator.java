package com.inscada.migrator;

/**
 *
 * @author fadime
 */
public interface Migrator {

    void transferEventLogs(String startE, String endE);

    void transferFiredAlarms(String startF, String endF);

    void transferVariableValues(String startV, String endV);

    boolean testPostgresqlConnection(ConnectionInfo connectionInfo);

    boolean testInfluxDbConnection(ConnectionInfo connectionInfo);
}
