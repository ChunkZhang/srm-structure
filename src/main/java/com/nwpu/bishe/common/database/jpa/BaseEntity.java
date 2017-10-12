/*
 * Copyright 2016 Qunar.com All right reserved. This software is the
 * confidential and proprietary information of Qunar.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Qunar.com.
 */
package com.nwpu.bishe.common.database.jpa;

import com.google.common.base.MoreObjects;

import javax.persistence.*;

/**
 * 实现描述：实体基类
 *
 * @author chaoyi.he
 * @version v1.0.0
 * @see 
 * @since 2016年2月15日 下午3:43:29
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // http://256.com/gray/docs/misc/hibernate_lazy_field_access_annotations.shtml
    @Access(AccessType.PROPERTY)
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        if (id == 0L)
            return super.hashCode();
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseEntity other = (BaseEntity) obj;
        if (id != other.id)
            return false;
        else if (id == 0L && other.id == 0L)
            return super.equals(obj);
        return true;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).toString();
    }

}
