package com.example.lance.bartapp.Model;

/**
 * Created by lance on 8/5/2017.
 */

public class Last {

    private String mTransferCode;
    private String mOrigTimeMin;
    private String mLine;


    public Last(
            String transferCode,
            String origTimeMin,
            String line) {
        mTransferCode = transferCode;
        mOrigTimeMin = origTimeMin;
        mLine = line;


    }

    public String getTransferCode() {
        return mTransferCode;
    }
    public String getOrigTimeMin() {
        return mOrigTimeMin;
    }
    public String getLine() {
        return mLine;
    }



    public static class Builder {

        private String mTransferCode;
        private String mOrigTimeMin;
        private String mLine;


        public Builder() {}

        public Builder setTransferCode(String transferCode) {
            mTransferCode = transferCode;
            return this;
        }



        public Builder setOrigTimeMin(String origTimeMin) {
            mOrigTimeMin = origTimeMin;
            return this;
        }



        public Builder setLine(String line) {
            mLine = line;
            return this;
        }




        public Last build() {
            return new Last(
                    mTransferCode,

                    mOrigTimeMin,

                    mLine);
        }
    }


}
