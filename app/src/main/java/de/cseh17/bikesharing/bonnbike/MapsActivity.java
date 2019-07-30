package de.cseh17.bikesharing.bonnbike;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ProcessLifecycleOwner;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.maps.android.clustering.ClusterManager;

import java.util.Objects;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import de.cseh17.bikesharing.bonnbike.BikeModel.AppLifecycleListener;
import de.cseh17.bikesharing.bonnbike.BikeModel.Place;
import de.cseh17.bikesharing.bonnbike.Remote.APIService;
import de.cseh17.bikesharing.bonnbike.Remote.GoogleApiService;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private static final int DEFAULT_ZOOM = 15;
    private static final LatLng DEFAULT_LOCATION = new LatLng(50.73438, 7.09549);
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private AppInfoFragment appInfoFragment;
    private APIService mService;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationRequest mLocationRequest;
    private Boolean mLocationPermissionGranted;
    private Location mLastKnownLocation;
    private LocationCallback mLocationCallback;
    private ClusterManager<Place> BikeClusterManager;
    private FloatingActionButton floatingActionInfoButton;
    private FloatingActionButton floatinggetMyLocationButton;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    // ------------------------ UI ---------------------------
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);

        // Initialize all fragments
        appInfoFragment = new AppInfoFragment();

        // Check if mapFragment is not null
        assert mapFragment != null : "mapFragment is null";
        mapFragment.getMapAsync(this);

        // Create myLocation & info floating Buttons
        floatingActionInfoButton = findViewById(R.id.infoButton);
        floatinggetMyLocationButton = findViewById(R.id.myLocationButton);
        floatingActionInfoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                ft.add(R.id.map_fragment, appInfoFragment).addToBackStack(null).commit();
                floatingActionInfoButton.setClickable(false);
                floatinggetMyLocationButton.setClickable(false);
            }
        });

        floatinggetMyLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDeviceLocation();
            }
        });

        // Initialize the mobile ad provider service from Google
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        // Add an add to the bottom of the map fragment
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    // ------------------------ NON - UI ---------------------

        // Initialize API Services
        mService = GoogleApiService.getGoogleApiService();

        // Start location client
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Register lifecycle observer
        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AppLifecycleListener());

        // Create & set the location request interval for the mLocationRequest object
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(90000);
        mLocationRequest.setFastestInterval(90000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        // Set up a LocationCallback object, that receives periodical location data
        mLocationCallback = new LocationCallback(){

            @Override
            public void onLocationResult(LocationResult locationResult){
                if (locationResult == null){
                    return;
                }
                for (Location location : locationResult.getLocations()){
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(),location.getLongitude())));
                    LoadBikes.getBikes(mService, MapsActivity.this, BikeClusterManager);
                    Log.i("Location:", "was updated");
                }
            }
        };
    }

    protected void onPause(){
        super.onPause();

        // If the app returns to background stop location updates
        stopLocationUpdates();
    }

    protected void onResume(){
        super.onResume();

        // When the app returns from background start location updates
        startLocationUpdate();

        // Check for internet connection
        ConnectivityManager mConnectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        // If there is a connection, do the search. If there is no connection, show error message to user.
        assert mConnectivityManager != null : "ConnectivityManager is null";
        if (!CheckConnection.isConnected(mConnectivityManager)) {

            // If there is no internet connection, display an error message
            AlertDialog dialog = CustomDialogAlertBuilder.onCreateDialog(this, getResources().getString(R.string.no_internet_alert_DE_title), getResources().getString(R.string.no_internet_alert_DE), "OK");
            dialog.show();

        } else {

            // If the app returned from background, and there is a connection reload the map, and start location updates
            if (mMap != null){
                onMapReady(mMap);
            }
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();

        // When back is pressed and the app return from other fragments, make buttons on the map available again.
        floatingActionInfoButton.setClickable(true);
        floatinggetMyLocationButton.setClickable(true);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Clean the map in order to eliminate duplicates
        mMap.clear();

        // Update the UI when the map finished loading
        updateLocationUI();

        // Set up ClusterManager
        BikeClusterManager = new ClusterManager<>(this, mMap);

        // Set custom cluster renderer
        BikeClusterManager.setRenderer(new CustomClusterManager(this, mMap, BikeClusterManager));

        // Set a clickListener that listens to the click on the markers, and displays an informationWindow
        BikeClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<Place>() {
            @Override
            public boolean onClusterItemClick(Place place) {
                CustomBikeAndRackInfoWindow.getCurrentSelectedItem(place);
                return false;
            }
        });

        // Set the custom infoWindowAdapter
        BikeClusterManager.getMarkerCollection().setOnInfoWindowAdapter(new CustomBikeAndRackInfoWindow(this));

        mMap.setOnCameraIdleListener(BikeClusterManager);
        mMap.setOnMarkerClickListener(BikeClusterManager);
        mMap.setInfoWindowAdapter(BikeClusterManager.getMarkerManager());
        mMap.getUiSettings().setMyLocationButtonEnabled(false);

        //LoadBikes.getBikes(mService, this, BikeClusterManager);
        LoadServiceArea.getNetworkServiceAreas(mService, this, mMap);

        // Move the navigation Buttons set to the upper right corner
        assert mapFragment.getView() != null : "MapFragment was not found";
        View navigationButtonSet = ((View) (mapFragment.getView().findViewById(Integer.parseInt("1")).getParent())).findViewById(Integer.parseInt("4"));
        RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) navigationButtonSet.getLayoutParams();
        rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        rlp.setMargins(0, 30, 30, 0);

    }

    // Ask user for location permissions
    private void getLocationPermission() {

        // Check if the explanation should be showed
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            // Show an explanation to the user *ASYNCHRONUSLY*, don't block this thread waiting for the users response
            new AlertDialog.Builder(this)
                    .setTitle("Achtung")
                    .setMessage(getString(R.string.location_acces_message))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            // Prompt the user once explanation has been shown
                            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                        }
                    })
                    .create()
                    .show();
        } else {

            // No explanation needed - request permission
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){

        mLocationPermissionGranted = false;

        // If the request is cancelled, the result array is empty
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // Request was granted.
                mLocationPermissionGranted = true;
                updateLocationUI();
                getDeviceLocation();
            }
        }
    }

    private void updateLocationUI(){

        // Check if there is a map
        if (mMap != null){
            try {
                if (mLocationPermissionGranted) {
                    mMap.setMyLocationEnabled(true);
                    floatinggetMyLocationButton.setEnabled(true);
                } else {
                    mMap.setMyLocationEnabled(false);
                    floatinggetMyLocationButton.setEnabled(false);
                    mLastKnownLocation = null;
                }
            } catch (SecurityException e) {
                Log.e("Exception: %s", Objects.requireNonNull(e.getMessage()));
            }
        }
    }

    private void getDeviceLocation(){
        try {
            if (mLocationPermissionGranted){
                Task locationResult = mFusedLocationClient.getLastLocation();
                locationResult.addOnCompleteListener(this, new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()){

                            // Set the map's camera position to the current location of the device
                            mLastKnownLocation = (Location) task.getResult();
                            assert mLastKnownLocation != null : "mLastKnowLocation is null. There is no last known location available";
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mLastKnownLocation.getLatitude(), mLastKnownLocation.getLongitude()), DEFAULT_ZOOM ));
                        } else {
                            Log.d("no current location", "Current location is null. Using defaults");
                            Log.e("Location error", "Exception: %s", task.getException());
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, DEFAULT_ZOOM));
                            floatinggetMyLocationButton.setEnabled(false);
                        }
                    }
                });
            }
        } catch (SecurityException e){
            Log.e("Exception: %s", Objects.requireNonNull(e.getMessage()));
        }
    }

    private void startLocationUpdate(){
        if (checkLocationPermission()) {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
            updateLocationUI();
            getDeviceLocation();
        }
    }

    private void stopLocationUpdates(){
        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
    }

    private boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mLocationPermissionGranted = true;
            return true;
        } else {
            getLocationPermission();
            mLocationPermissionGranted = false;
            return false;
        }
    }
}
