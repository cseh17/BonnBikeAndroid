
package de.cseh17.bikesharing.bonnbike.BikeModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Bikes {

    @SerializedName("countries")
    private List<Country> mCountries;

    public List<Country> getCountries() {
        return mCountries;
    }

    public void setCountries(List<Country> countries) {
        mCountries = countries;
    }

}
