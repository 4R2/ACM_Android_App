package com.example.sharkawy.myapplication;


import com.example.sharkawy.myapplication.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("na-2019")
    Call<List<Event>> getEvents();
}
