package com.example.zhengjun.nocopypasteedittextdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * OKLINE(Hangzhou) Co.,Ltd
 * Author:Zheng Jun
 * E-Mail:zhengjun@okline.cn
 * Date: 2016/11/16. 15:58
 */

public interface DownloadService {
    @GET("top250")
    Call<MovieEntity> getTopMovie(@Query("start")int start,@Query("count")int count);
}
