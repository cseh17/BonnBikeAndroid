package de.cseh17.bikesharing.bonnbike;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.GoogleMap;

import java.util.Objects;

import de.cseh17.bikesharing.bonnbike.NetworkAreaModel.NetworkServiceArea;
import de.cseh17.bikesharing.bonnbike.Remote.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class LoadServiceArea {

    static void getNetworkServiceAreas(APIService mService, Context mContext, final GoogleMap mMap){

        Log.i("Request was sent:", "service areas");

        // Get request URL from resource
        final String requestUrl = mContext.getString(R.string.api_request_string_service_area);

        // Make API call to get service area
        mService.getNetworkServiceAreas(requestUrl)
                .enqueue(new Callback<NetworkServiceArea>() {
                    @Override
                    public void onResponse(@NonNull Call<NetworkServiceArea> call, @NonNull Response<NetworkServiceArea> response) {

                        // Check if the response is not null
                        if (response.isSuccessful() && response.code() == 200){

                            // Check if the response body is not null, if yes then assert
                            assert response.body() != null : "Response body is null";
                            MapOperations.drawPolygonOntoMap(mMap, response.body().getGeojson().getNodeValue().getFeatures());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<NetworkServiceArea> call, @NonNull Throwable t) {
                        Log.e("Error", Objects.requireNonNull(t.getMessage()));
                    }
                });
    }
}
