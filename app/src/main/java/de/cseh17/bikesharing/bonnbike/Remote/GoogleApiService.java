package de.cseh17.bikesharing.bonnbike.Remote;

public class GoogleApiService {

    private static final String GOOGLE_API_URL = "https://maps.googleapis.com/";
    public static APIService getGoogleApiService(){
        return RetrofitClient.getClient(GOOGLE_API_URL).create(APIService.class);
    }
}
