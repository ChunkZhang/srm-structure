/*
 * Copyright 2016 Qunar.com All right reserved. This software is the
 * confidential and proprietary information of Qunar.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Qunar.com.
 */
package com.nwpu.bishe.common.database.jpa;

import java.sql.Types;

/**
 * 实现描述：Postgresql的JPA方言
 *
 * @author chaoyi.he
 * @version v1.0.0
 * @see 
 * @since 2016年5月23日 上午11:57:40
 */
public class PostgreSQL9Dialect extends org.hibernate.dialect.PostgreSQL9Dialect {

    public PostgreSQL9Dialect() {
        super();
        this.registerColumnType(Types.JAVA_OBJECT, "json");

    }

}
