package com.example.wel.upkeep;

public enum ModelObject {

    RED(R.string.red, R.layout.activity_landlord),
    BLUE(R.string.blue, R.layout.activity_tenant),
    GREEN(R.string.green, R.layout.activity_tradesman),
    WHITE(R.string.white, R.layout.activity_tradesman);


    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}