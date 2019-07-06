
package de.cseh17.bikesharing.bonnbike.NetworkAreaModel;

import com.google.gson.annotations.SerializedName;

public class Feature {

    @SerializedName("geometry")
    private Geometry mGeometry;
    @SerializedName("properties")
    private Properties mProperties;
    @SerializedName("type")
    private String mType;

    public Geometry getGeometry() {
        return mGeometry;
    }

    public void setGeometry(Geometry geometry) {
        mGeometry = geometry;
    }

    public Properties getProperties() {
        return mProperties;
    }

    public void setProperties(Properties properties) {
        mProperties = properties;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
