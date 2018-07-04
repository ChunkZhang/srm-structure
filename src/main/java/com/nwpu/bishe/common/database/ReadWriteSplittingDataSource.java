
package com.nwpu.bishe.common.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;


public class ReadWriteSplittingDataSource extends AbstractRoutingDataSource {

    private static final String SLAVE_DATASOURCE_KEY = "SLAVE";
    private static final String MASTER_DATASOURCE_KEY = "MASTER";

    @Override
    protected Object determineCurrentLookupKey() {
        if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) // 只读事务内
            return SLAVE_DATASOURCE_KEY;
        return MASTER_DATASOURCE_KEY;
    }

}
