package com.example.lance.bartapp.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 8/5/2017.
 */

public class Trip {
    private String mOrigin;
    private String mDestination;
    private String mOrigTimeMin;
    private String mOrigTimeDate;
    private List<Last> Listz;

    public Trip(
            String origin,
            String destination,
            String origTimeMin,
            String origTimeDate,

            List<Last> lisst) {
        mOrigin = origin;
        mDestination = destination;
        mOrigTimeMin = origTimeMin;
        mOrigTimeDate = origTimeDate;
        Listz = lisst;
    }

    public String getOrigin() {
        return mOrigin;
    }

    public String getDestination() {
        return mDestination;
    }

    public String getOrigTimeMin() {
        return mOrigTimeMin;
    }

    public String getOrigTimeDate() {
        return mOrigTimeDate;
    }



    public List<Last> getL() {
        return Listz;
    }

    public static class TripBuilder {

        private String mOrigin;
        private String mDestination;
        private String mOrigTimeMin;
        private String mOrigTimeDate;
        private String mDestTimeMin;
        private String mDestTimeDate;
        private List<Last> mL = new ArrayList<Last>();

        public TripBuilder() {}

        public TripBuilder setOrigin(String origin) {
            mOrigin = origin;
            return this;
        }

        public TripBuilder setDestination(String destination) {
            mDestination = destination;
            return this;
        }

        public TripBuilder setOrigTimeMin(String origTimeMin) {
            mOrigTimeMin = origTimeMin;
            return this;
        }

        public TripBuilder setOrigTimeDate(String origTimeDate) {
            mOrigTimeDate = origTimeDate;
            return this;
        }

        public TripBuilder setDestTimeMin(String destTimeMin) {
            mDestTimeMin = destTimeMin;
            return this;
        }

        public TripBuilder setDestTimeDate(String destTimeDate) {
            mDestTimeDate = destTimeDate;
            return this;
        }

        public TripBuilder addl(List<Last> les) {
            mL.addAll(les);
            return this;
        }

        public TripBuilder addL(Last les) {
            mL.add(les);
            return this;
        }

        public Trip build() {
            return new Trip(
                    mOrigin,
                    mDestination,
                    mOrigTimeMin,
                    mOrigTimeDate,
                    mL);
        }
    }
}
