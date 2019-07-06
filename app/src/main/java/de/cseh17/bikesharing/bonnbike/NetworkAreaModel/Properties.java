
package de.cseh17.bikesharing.bonnbike.NetworkAreaModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("category")
    private String mCategory;
    @SerializedName("cityId")
    private Object mCityId;
    @SerializedName("color")
    private String mColor;
    @SerializedName("domain")
    private String mDomain;
    @SerializedName("fill")
    private String mFill;
    @SerializedName("name")
    private String mName;
    @SerializedName("serviceCases")
    private List<String> mServiceCases;

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public Object getCityId() {
        return mCityId;
    }

    public void setCityId(Object cityId) {
        mCityId = cityId;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getDomain() {
        return mDomain;
    }

    public void setDomain(String domain) {
        mDomain = domain;
    }

    public String getFill() {
        return mFill;
    }

    public void setFill(String fill) {
        mFill = fill;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<String> getServiceCases() {
        return mServiceCases;
    }

    public void setServiceCases(List<String> serviceCases) {
        mServiceCases = serviceCases;
    }

}
