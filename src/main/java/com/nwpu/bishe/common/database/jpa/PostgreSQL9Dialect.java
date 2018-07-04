
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
