package de.cseh17.bikesharing.bonnbike;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.ClusterManager;

import java.util.Objects;

import de.cseh17.bikesharing.bonnbike.BikeModel.Bikes;
import de.cseh17.bikesharing.bonnbike.BikeModel.Place;
import de.cseh17.bikesharing.bonnbike.Remote.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class LoadBikes {

    static void getBikes(APIService mService, Context mContext, final ClusterManager<Place> mClusterManager){

        Log.i("Request was sent:", "bikes");

        // Get request URL from resources
        String requestUrl = mContext.getString(R.string.api_request_string_bikes);

        // Make API call to get bikes
        mService.getBikes(requestUrl)
                .enqueue(new Callback<Bikes>() {
                    @Override
                    public void onResponse(@NonNull Call<Bikes> call, @NonNull Response<Bikes> response) {

                        // Check if the response is not null
                        if (response.code() == 200 && response.isSuccessful()){

                            // Check if the response body is not null, if yes then assert
                            assert response.body() != null : "Response body is null";
                            for (Place item : response.body().getCountries().get(0).getCities().get(0).getPlaces()) {

                                mClusterManager.addItem(item);
                                Log.i("Bikes & Racks", item.getName());
                            }
                            mClusterManager.cluster();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull  Call<Bikes> call, @NonNull Throwable t) {
                        Log.e("Error", Objects.requireNonNull(t.getMessage()));
                    }
                });
    }
}
