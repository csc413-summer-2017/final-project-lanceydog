package com.example.lance.bartapp.Model;

/**
 * Created by lance on 8/5/2017.
 */

public class Station {


    private String mName;
    private String mAbbr;



    public Station(
            String name,
            String abbr) {
        mName = name;
        mAbbr = abbr;

    }

    public String getName() {
        return mName;
    }

    public String getAbbr() {
        return mAbbr;
    }



    public static class StationBuilder {

        private String mName;
        private String mAbbr;


        public StationBuilder() {}

        public StationBuilder setName(String name) {
            mName = name;
            return this;
        }

        public StationBuilder setAbbr(String abbr) {
            mAbbr = abbr;
            return this;
        }


        public Station build() {
            return new Station(
                    mName,
                    mAbbr);
        }
    }

}
