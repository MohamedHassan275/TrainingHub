package com.example.mohamedhassan.traininghub.Model_LoginAndRegister;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {


    //The register call
    @FormUrlEncoded
    @POST("register")
    Call<Result> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phone") String phone,
            @Field("gender") String gander,
            @Field("city") String city,
            @Field("district") String district


    );


    //the signin call
    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @PUT("update_phone/{id}/{phone}")
    Call<Result> updatePhone(
            @Path("id") int userId,
            @Path("phone") String phone
    );

    @PUT("update_password/{id}/{old_password}/{password}")
    Call<Result> resetPassword(
            @Path("id") int userId,
            @Path("old_password") String oldPassword,
            @Path("password") String password
    );


}
