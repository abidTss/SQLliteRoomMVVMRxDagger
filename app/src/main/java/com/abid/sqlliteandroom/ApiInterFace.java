package com.abid.sqlliteandroom;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by abid on 11/26/17.
 */

public interface ApiInterFace {

    /*@GET("selectTrainerAllNew/")
    Call<List<User>> getPosts();*/
    @POST("selectTrainerAllNew/")
    @FormUrlEncoded
    Observable<PdfData> getPosts(
            @Field("PageNo") int a,
            @Field("NoOfRecords") int b,
            @Field("Keyword") String c

            );

}
