
package de.cseh17.bikesharing.bonnbike.NetworkAreaModel;

import com.google.gson.annotations.SerializedName;

public class Geojson {

    @SerializedName("nodeValue")
    private NodeValue mNodeValue;

    public NodeValue getNodeValue() {
        return mNodeValue;
    }

    public void setNodeValue(NodeValue nodeValue) {
        mNodeValue = nodeValue;
    }

}
