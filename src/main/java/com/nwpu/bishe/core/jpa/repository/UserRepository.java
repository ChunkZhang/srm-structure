package com.nwpu.bishe.core.jpa.repository;

import com.nwpu.bishe.common.database.jpa.BaseRepository;
import com.nwpu.bishe.core.jpa.entity.User;

/**
 * Created by chunk on 2017/10/12.
 */
public interface UserRepository extends BaseRepository<User> {
    User findById(Long id);
}
