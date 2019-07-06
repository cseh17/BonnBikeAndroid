
package de.cseh17.bikesharing.bonnbike.BikeModel;

import java.util.List;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.google.maps.android.clustering.ClusterItem;

public class Place implements ClusterItem {

    @SerializedName("address")
    private Object mAddress;
    @SerializedName("bike")
    private Boolean mBike;
    @SerializedName("bike_list")
    private List<BikeList> mBikeList;
    @SerializedName("bike_numbers")
    private List<String> mBikeNumbers;
    @SerializedName("bike_racks")
    private Long mBikeRacks;
    @SerializedName("bike_types")
    private BikeTypes mBikeTypes;
    @SerializedName("bikes")
    private Long mBikes;
    @SerializedName("booked_bikes")
    private Long mBookedBikes;
    @SerializedName("free_racks")
    private Long mFreeRacks;
    @SerializedName("free_special_racks")
    private Long mFreeSpecialRacks;
    @SerializedName("lat")
    private Double mLat;
    @SerializedName("lng")
    private Double mLng;
    @SerializedName("maintenance")
    private Boolean mMaintenance;
    @SerializedName("name")
    private String mName;
    @SerializedName("number")
    private Long mNumber;
    @SerializedName("place_type")
    private String mPlaceType;
    @SerializedName("rack_locks")
    private Boolean mRackLocks;
    @SerializedName("special_racks")
    private Long mSpecialRacks;
    @SerializedName("spot")
    private Boolean mSpot;
    @SerializedName("terminal_type")
    private String mTerminalType;
    @SerializedName("uid")
    private Long mUid;

    public Object getAddress() {
        return mAddress;
    }

    public void setAddress(Object address) {
        mAddress = address;
    }

    public Boolean getBike() {
        return mBike;
    }

    public void setBike(Boolean bike) {
        mBike = bike;
    }

    public List<BikeList> getBikeList() {
        return mBikeList;
    }

    public void setBikeList(List<BikeList> bikeList) {
        mBikeList = bikeList;
    }

    public List<String> getBikeNumbers() {
        return mBikeNumbers;
    }

    public void setBikeNumbers(List<String> bikeNumbers) {
        mBikeNumbers = bikeNumbers;
    }

    public Long getBikeRacks() {
        return mBikeRacks;
    }

    public void setBikeRacks(Long bikeRacks) {
        mBikeRacks = bikeRacks;
    }

    public BikeTypes getBikeTypes() {
        return mBikeTypes;
    }

    public void setBikeTypes(BikeTypes bikeTypes) {
        mBikeTypes = bikeTypes;
    }

    public Long getBikes() {
        return mBikes;
    }

    public void setBikes(Long bikes) {
        mBikes = bikes;
    }

    public Long getBookedBikes() {
        return mBookedBikes;
    }

    public void setBookedBikes(Long bookedBikes) {
        mBookedBikes = bookedBikes;
    }

    public Long getFreeRacks() {
        return mFreeRacks;
    }

    public void setFreeRacks(Long freeRacks) {
        mFreeRacks = freeRacks;
    }

    public Long getFreeSpecialRacks() {
        return mFreeSpecialRacks;
    }

    public void setFreeSpecialRacks(Long freeSpecialRacks) {
        mFreeSpecialRacks = freeSpecialRacks;
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

    public Boolean getMaintenance() {
        return mMaintenance;
    }

    public void setMaintenance(Boolean maintenance) {
        mMaintenance = maintenance;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getNumber() {
        return mNumber;
    }

    public void setNumber(Long number) {
        mNumber = number;
    }

    public String getPlaceType() {
        return mPlaceType;
    }

    public void setPlaceType(String placeType) {
        mPlaceType = placeType;
    }

    public Boolean getRackLocks() {
        return mRackLocks;
    }

    public void setRackLocks(Boolean rackLocks) {
        mRackLocks = rackLocks;
    }

    public Long getSpecialRacks() {
        return mSpecialRacks;
    }

    public void setSpecialRacks(Long specialRacks) {
        mSpecialRacks = specialRacks;
    }

    public Boolean getSpot() {
        return mSpot;
    }

    public void setSpot(Boolean spot) {
        mSpot = spot;
    }

    public String getTerminalType() {
        return mTerminalType;
    }

    public void setTerminalType(String terminalType) {
        mTerminalType = terminalType;
    }

    public Long getUid() {
        return mUid;
    }

    public void setUid(Long uid) {
        mUid = uid;
    }

    @Override
    public LatLng getPosition() {
        return new LatLng(getLat(),getLng());
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getSnippet() {
        return null;
    }
}
