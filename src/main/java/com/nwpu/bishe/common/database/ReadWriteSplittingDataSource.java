/*
 * Copyright 2016 Qunar.com All right reserved. This software is the
 * confidential and proprietary information of Qunar.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Qunar.com.
 */
package com.nwpu.bishe.common.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 实现描述：读写分离数据源，使用 @Transactional(readOnly = true, propagation = Propagation.SUPPORTS) 来标识该方法走读库
 * 
    <bean id="readWriteSplittingDataSource"
        class="com.qunar.marketing.common.database.ReadWriteSplittingDataSource">
        <property name="targetDataSources">
            <map>
                <entry key="MASTER" value-ref="writeDataSource" />
                <entry key="SLAVE" value-ref="readDataSource" />
            </map>
        </property>
    </bean>
 *
 * @author chaoyi.he
 * @version v1.0.0
 * @see 
 * @since 2016年5月17日 下午3:52:33
 */
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
