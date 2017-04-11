package com.crackncrunch.proguardtutorial;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("person")
    Call<PersonResponse> getPerson();

    @GET("person")
    Call<PersonResponse2> getPerson2();

    @GET("person")
    Call<PersonResponse3> getPerson3();
}
