package com.example.sharkawy.myapplication;

import com.example.sharkawy.myapplication.Event;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hackathons {
    @SerializedName("array")
    List<Event> events;

    //List of events. We name it "getEvents" because it's the method
    //That will return the events from this class.
    public List<Event> getEvents() {
        return events;
    }

}
