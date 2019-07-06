package de.cseh17.bikesharing.bonnbike.Remote;

import de.cseh17.bikesharing.bonnbike.BikeModel.Bikes;
import de.cseh17.bikesharing.bonnbike.NetworkAreaModel.NetworkServiceArea;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIService {

    @GET
    Call<Bikes> getBikes(@Url String url);

    @GET
    Call<NetworkServiceArea> getNetworkServiceAreas(@Url String url);
}
