package com.inscada.migrator;

/**
 *
 * @author fadime
 */
public interface Migrator {

    void transferEventLogs(String startE, String endE);

    void transferFiredAlarms(String startF, String endF,int limit,int offset);

    void transferVariableValues(String startV, String endV,int limit,int offset);

    boolean testPostgresqlConnection(ConnectionInfo connectionInfo);

    boolean testInfluxDbConnection(ConnectionInfo connectionInfo);

    public void threadProduce(int nThreads , int nBatchSize, String tableName,String startTime,String endTime);
}
