
package de.cseh17.bikesharing.bonnbike.BikeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BikeList {

    @SerializedName("active")
    private Boolean mActive;
    @SerializedName("battery_pack")
    private Object mBatteryPack;
    @SerializedName("bike_type")
    private Long mBikeType;
    @SerializedName("boardcomputer")
    private Long mBoardcomputer;
    @SerializedName("electric_lock")
    private Boolean mElectricLock;
    @SerializedName("lock_types")
    private List<String> mLockTypes;
    @SerializedName("number")
    private String mNumber;
    @SerializedName("pedelec_battery")
    private Object mPedelecBattery;
    @SerializedName("state")
    private String mState;

    public Boolean getActive() {
        return mActive;
    }

    public void setActive(Boolean active) {
        mActive = active;
    }

    public Object getBatteryPack() {
        return mBatteryPack;
    }

    public void setBatteryPack(Object batteryPack) {
        mBatteryPack = batteryPack;
    }

    public Long getBikeType() {
        return mBikeType;
    }

    public void setBikeType(Long bikeType) {
        mBikeType = bikeType;
    }

    public Long getBoardcomputer() {
        return mBoardcomputer;
    }

    public void setBoardcomputer(Long boardcomputer) {
        mBoardcomputer = boardcomputer;
    }

    public Boolean getElectricLock() {
        return mElectricLock;
    }

    public void setElectricLock(Boolean electricLock) {
        mElectricLock = electricLock;
    }

    public List<String> getLockTypes() {
        return mLockTypes;
    }

    public void setLockTypes(List<String> lockTypes) {
        mLockTypes = lockTypes;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public Object getPedelecBattery() {
        return mPedelecBattery;
    }

    public void setPedelecBattery(Object pedelecBattery) {
        mPedelecBattery = pedelecBattery;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

}
