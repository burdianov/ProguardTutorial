package com.crackncrunch.proguardtutorial;


import com.crackncrunch.proguardtutorial.response.PersonResponse;
import com.crackncrunch.proguardtutorial.response.PersonResponse2;
import com.crackncrunch.proguardtutorial.response.PersonResponse3;

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
