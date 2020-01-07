package com.example.validate.service;

import com.example.validate.entity.OrderUserDO;
import org.springframework.stereotype.Repository;

/**
 * @author LYH
 * @date 2020/01/07 16:12
 */
@Repository
public interface UserBiz {

    /***
     * 获取用户的信息
     *
     * @param userId
     * @author LYH
     * @date 2020/1/7 16:17
     * @return {@link OrderUserDO}
     */
    OrderUserDO getUserInfoById(Integer userId);
}
