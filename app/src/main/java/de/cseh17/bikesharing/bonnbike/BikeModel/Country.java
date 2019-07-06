
package de.cseh17.bikesharing.bonnbike.BikeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import de.cseh17.bikesharing.bonnbike.BikeModel.City;

public class Country {

    @SerializedName("available_bikes")
    private Long mAvailableBikes;

    @SerializedName("cities")
    private List<City> mCities;

    @SerializedName("country_calling_code")
    private String mCountryCallingCode;

    @SerializedName("country_name")
    private String mCountryName;

    @SerializedName("currency")
    private String mCurrency;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("hotline")
    private String mHotline;

    @SerializedName("language")
    private String mLanguage;

    @SerializedName("lat")
    private Double mLat;

    @SerializedName("lng")
    private Double mLng;

    @SerializedName("name")
    private String mName;

    @SerializedName("policy")
    private String mPolicy;

    @SerializedName("pricing")
    private String mPricing;

    @SerializedName("set_point_bikes")
    private Long mSetPointBikes;

    @SerializedName("system_operator_address")
    private String mSystemOperatorAddress;

    @SerializedName("terms")
    private String mTerms;

    @SerializedName("website")
    private String mWebsite;

    public Long getAvailableBikes() {
        return mAvailableBikes;
    }

    public void setAvailableBikes(Long availableBikes) {
        mAvailableBikes = availableBikes;
    }

    public List<City> getCities() {
        return mCities;
    }

    public void setCities(List<City> cities) {
        mCities = cities;
    }

    public String getCountryCallingCode() {
        return mCountryCallingCode;
    }

    public void setCountryCallingCode(String countryCallingCode) {
        mCountryCallingCode = countryCallingCode;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public void setCountryName(String countryName) {
        mCountryName = countryName;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getHotline() {
        return mHotline;
    }

    public void setHotline(String hotline) {
        mHotline = hotline;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public Double getLat() {
        return mLat;
    }

    public void setLat(Double lat) {
        mLat = lat;
    }

    public Double getLng() {
        return mLng;
    }

    public void setLng(Double lng) {
        mLng = lng;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPolicy() {
        return mPolicy;
    }

    public void setPolicy(String policy) {
        mPolicy = policy;
    }

    public String getPricing() {
        return mPricing;
    }

    public void setPricing(String pricing) {
        mPricing = pricing;
    }

    public Long getSetPointBikes() {
        return mSetPointBikes;
    }

    public void setSetPointBikes(Long setPointBikes) {
        mSetPointBikes = setPointBikes;
    }

    public String getSystemOperatorAddress() {
        return mSystemOperatorAddress;
    }

    public void setSystemOperatorAddress(String systemOperatorAddress) {
        mSystemOperatorAddress = systemOperatorAddress;
    }

    public String getTerms() {
        return mTerms;
    }

    public void setTerms(String terms) {
        mTerms = terms;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String website) {
        mWebsite = website;
    }
}
