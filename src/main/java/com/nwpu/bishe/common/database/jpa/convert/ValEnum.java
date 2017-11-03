/*
 * Copyright 2016 Qunar.com All right reserved. This software is the
 * confidential and proprietary information of Qunar.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Qunar.com.
 */
package com.nwpu.bishe.common.database.jpa.convert;

/**
 * 实现描述：可以获取到value的枚举接口
 *
 * @author chaoyi.he
 * @version v1.0.0
 * @see 
 * @since 2016年5月18日 上午1:18:12
 */
public interface ValEnum<T> {

    T value();

}
