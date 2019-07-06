
package de.cseh17.bikesharing.bonnbike.NetworkAreaModel;

import com.google.gson.annotations.SerializedName;

public class NetworkServiceArea {

    @SerializedName("geojson")
    private Geojson mGeojson;
    @SerializedName("server_time")
    private Long mServerTime;

    public Geojson getGeojson() {
        return mGeojson;
    }

    public void setGeojson(Geojson geojson) {
        mGeojson = geojson;
    }

    public Long getServerTime() {
        return mServerTime;
    }

    public void setServerTime(Long serverTime) {
        mServerTime = serverTime;
    }

}
