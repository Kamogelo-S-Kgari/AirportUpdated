package com.example.airport;

import com.example.airport.Model.Details;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("maps/api/place/nearbysearch/json")
    Call<Details> getRestorant(@Query("location") String location,
                               @Query("radius") Integer radius,
                               @Query("type") String type,
                               @Query("key") String key);

    //AND I will have to drop a code of an API Here For Avaition
}
