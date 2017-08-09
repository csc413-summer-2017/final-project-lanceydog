package com.example.lance.bartapp.Model;

/**
 * Created by lance on 8/5/2017.
 */

public class Last {

    private String mTransferCode;
    private String mOrigin;
    private String mDestination;
    private String mOrigTimeMin;
    private String mOrigTimeDate;
    private String mDestTimeMin;
    private String mDestTimeDate;
    private String mLine;
    private String mTrainHeadStation;
    private String mTrainIdx;

    public Last(
            String transferCode,
            String origin,
            String destination,
            String origTimeMin,
            String origTimeDate,
            String destTimeMin,
            String destTimeDate,
            String line,
            String trainHeadStation,
            String trainIdx) {
        mTransferCode = transferCode;
        mOrigin = origin;
        mDestination = destination;
        mOrigTimeMin = origTimeMin;
        mOrigTimeDate = origTimeDate;
        mDestTimeMin = destTimeMin;
        mDestTimeDate = destTimeDate;
        mLine = line;

        mTrainHeadStation = trainHeadStation;
        mTrainIdx = trainIdx;
    }

    public String getTransferCode() {
        return mTransferCode;
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

    public String getDestTimeMin() {
        return mDestTimeMin;
    }

    public String getDestTimeDate() {
        return mDestTimeDate;
    }

    public String getLine() {
        return mLine;
    }

    public String getTrainHeadStation() {
        return mTrainHeadStation;
    }

    public String getTrainIdx() {
        return mTrainIdx;
    }

    public static class Builder {

        private String mTransferCode;
        private String mOrigin;
        private String mDestination;
        private String mOrigTimeMin;
        private String mOrigTimeDate;
        private String mDestTimeMin;
        private String mDestTimeDate;
        private String mLine;
        private String mTrainHeadStation;
        private String mTrainIdx;

        public Builder() {}

        public Builder setTransferCode(String transferCode) {
            mTransferCode = transferCode;
            return this;
        }

        public Builder setOrigin(String origin) {
            mOrigin = origin;
            return this;
        }

        public Builder setDestination(String destination) {
            mDestination = destination;
            return this;
        }

        public Builder setOrigTimeMin(String origTimeMin) {
            mOrigTimeMin = origTimeMin;
            return this;
        }

        public Builder setOrigTimeDate(String origTimeDate) {
            mOrigTimeDate = origTimeDate;
            return this;
        }

        public Builder setDestTimeMin(String destTimeMin) {
            mDestTimeMin = destTimeMin;
            return this;
        }

        public Builder setDestTimeDate(String destTimeDate) {
            mDestTimeDate = destTimeDate;
            return this;
        }

        public Builder setLine(String line) {
            mLine = line;
            return this;
        }


        public Builder setTrainHeadStation(String trainHeadStation) {
            mTrainHeadStation = trainHeadStation;
            return this;
        }

        public Builder setTrainIdx(String trainIdx) {
            mTrainIdx = trainIdx;
            return this;
        }

        public Last build() {
            return new Last(
                    mTransferCode,
                    mOrigin,
                    mDestination,
                    mOrigTimeMin,
                    mOrigTimeDate,
                    mDestTimeMin,
                    mDestTimeDate,
                    mLine,
                    mTrainHeadStation,
                    mTrainIdx);
        }
    }


}
