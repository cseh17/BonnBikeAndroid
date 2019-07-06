
package de.cseh17.bikesharing.bonnbike.NetworkAreaModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NodeValue {

    @SerializedName("features")
    private List<Feature> mFeatures;
    @SerializedName("type")
    private String mType;

    public List<Feature> getFeatures() {
        return mFeatures;
    }

    public void setFeatures(List<Feature> features) {
        mFeatures = features;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
