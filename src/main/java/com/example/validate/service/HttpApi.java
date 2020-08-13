package com.example.validate.service;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Objects;

/**
 * @author LYH
 * @date 2020/08/13 13:47
 */
@RetrofitClient(baseUrl = "${http://localhost:20330/}")
public interface HttpApi {

    @GET("repairData/test")
    Objects getUserInfo(@Query("userId") int id);
}
