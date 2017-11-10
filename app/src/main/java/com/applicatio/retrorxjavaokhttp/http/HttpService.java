package com.applicatio.retrorxjavaokhttp.http;


import com.applicatio.retrorxjavaokhttp.base.BaseHttpResult;
import com.applicatio.retrorxjavaokhttp.bean.ResultBeans;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by tang on 17/8/17.
 * 网络请求的接口都在这里
 */

public interface HttpService {

//    @GET("constellation/getAll")
//    Observable<Constellation> getcons(@Query("consName") String consName, @Query
//            ("type") String type, @Query("key") String key);
//
//    @GET("/weather/index")
//    Observable<BaseHttpResult<ResultBean>> getweather(@Query("cityname") String cityname, @Query("format") int format
//            , @Query("key") String key);

    /**
     * 图片上传
     * //记录返回的url
     * url = requestBoday.string();
     * */
    @Multipart
    @POST("/file")
    Observable<ResponseBody> upload(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("driverexam/query")
    Observable<BaseHttpResult<ResultBeans>> test(@Field("appkey") String key, @Field("type") String type
            , @Field("subject") String subject, @Field("pagesize") String pagesize, @Field("pagenum") String pagenum
            , @Field("sort") String sort);




}
