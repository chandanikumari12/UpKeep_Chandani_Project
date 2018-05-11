package com.example.wel.upkeep;

public class DataObject {
    private String mText1;


    DataObject (String text1, String text2){
        mText1 = text1;

    }

    public DataObject(String s) {
        mText1 = s;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

}
