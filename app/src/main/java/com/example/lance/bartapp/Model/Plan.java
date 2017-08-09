package com.example.lance.bartapp.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 8/5/2017.
 */

public class Plan {


    private String mDate;
    private String mTime;
    private List<Trip> mTrips;

    public Plan(String date, String time, List<Trip> trips) {
        mDate = date;
        mTime = time;
        mTrips = trips;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }

    public List<Trip> getTrips() {
        return mTrips;
    }

    public static class ScheduleBuilder {

        private String mDate;
        private String mTime;
        private List<Trip> mTrips = new ArrayList<Trip>();

        public ScheduleBuilder() {}

        public ScheduleBuilder setDate(String date) {
            mDate = date;
            return this;
        }

        public ScheduleBuilder setTime(String time) {
            mTime = time;
            return this;
        }

        public ScheduleBuilder addTrips(List<Trip> trips) {
            mTrips.addAll(trips);
            return this;
        }

        public ScheduleBuilder addTrip(Trip trip) {
            mTrips.add(trip);
            return this;
        }

        public Plan build() {
            return new Plan(mDate, mTime, mTrips);
        }
    }



}
