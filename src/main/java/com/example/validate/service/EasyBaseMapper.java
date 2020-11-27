package com.example.validate.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @author LYH
 * @date 2020/11/27 11:32
 */
public interface EasyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 批量插入
     *
     * @param entityList
     * @return {@link Integer}
     * @author LYH
     * @date 2020/11/27 11:34
     */
    Integer insertBatchSomeColumn(Collection<T> entityList);
}
