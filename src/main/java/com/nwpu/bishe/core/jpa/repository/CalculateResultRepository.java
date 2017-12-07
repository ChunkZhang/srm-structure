package com.nwpu.bishe.core.jpa.repository;

import com.nwpu.bishe.common.database.jpa.BaseRepository;
import com.nwpu.bishe.core.jpa.entity.CalculateResult;

import java.util.List;

/**
 * Created by chunk on 2017/11/9.
 */
public interface CalculateResultRepository extends BaseRepository<CalculateResult> {

    List<CalculateResult> findByUserName(String userName);
}
