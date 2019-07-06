
package de.cseh17.bikesharing.bonnbike.BikeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("available_bikes")
    private Long mAvailableBikes;

    @SerializedName("bike_types")
    private BikeTypes mBikeTypes;

    @SerializedName("bounds")
    private Bounds mBounds;

    @SerializedName("lat")
    private Double mLat;

    @SerializedName("lng")
    private Double mLng;

    @SerializedName("name")
    private String mName;

    @SerializedName("num_places")
    private Long mNumPlaces;

    @SerializedName("places")
    private List<Place> mPlaces;

    @SerializedName("set_point_bikes")
    private Long mSetPointBikes;

    @SerializedName("uid")
    private Long mUid;

    public Long getAvailableBikes() {
        return mAvailableBikes;
    }

    public void setAvailableBikes(Long availableBikes) {
        mAvailableBikes = availableBikes;
    }

    public BikeTypes getBikeTypes() {
        return mBikeTypes;
    }

    public void setBikeTypes(BikeTypes bikeTypes) {
        mBikeTypes = bikeTypes;
    }

    public Bounds getBounds() {
        return mBounds;
    }

    public void setBounds(Bounds bounds) {
        mBounds = bounds;
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

    public Long getNumPlaces() {
        return mNumPlaces;
    }

    public void setNumPlaces(Long numPlaces) {
        mNumPlaces = numPlaces;
    }

    public List<Place> getPlaces() {
        return mPlaces;
    }

    public void setPlaces(List<Place> places) {
        mPlaces = places;
    }

    public Long getSetPointBikes() {
        return mSetPointBikes;
    }

    public void setSetPointBikes(Long setPointBikes) {
        mSetPointBikes = setPointBikes;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }
}
