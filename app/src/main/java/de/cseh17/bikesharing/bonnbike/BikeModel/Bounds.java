
package de.cseh17.bikesharing.bonnbike.BikeModel;

import com.google.gson.annotations.SerializedName;

public class Bounds {

    @SerializedName("north_east")
    private NorthEast mNorthEast;
    @SerializedName("south_west")
    private SouthWest mSouthWest;

    public NorthEast getNorthEast() {
        return mNorthEast;
    }

    public void setNorthEast(NorthEast northEast) {
        mNorthEast = northEast;
    }

    public SouthWest getSouthWest() {
        return mSouthWest;
    }

    public void setSouthWest(SouthWest southWest) {
        mSouthWest = southWest;
    }

}
