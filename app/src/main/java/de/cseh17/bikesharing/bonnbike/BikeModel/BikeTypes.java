
package de.cseh17.bikesharing.bonnbike.BikeModel;

import com.google.gson.annotations.SerializedName;

public class BikeTypes {

    @SerializedName("71")
    private Long m1;
    @SerializedName("undefined")
    private Long mUndefined;

    public Long getOne() {
        return m1;
    }

    public void setOne(Long one) {
        m1 = one;
    }

    public Long getUndefined() {
        return mUndefined;
    }

    public void setUndefined(Long undefined) {
        mUndefined = undefined;
    }

}
