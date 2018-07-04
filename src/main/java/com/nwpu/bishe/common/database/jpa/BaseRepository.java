
package com.nwpu.bishe.common.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * 实现描述：仓库父接口
 *
 * @author chaoyi.he
 * @version v1.0.0
 * @see 
 * @since 2016年5月17日 下午10:32:53
 */
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long>, QueryDslPredicateExecutor<T> {
}
