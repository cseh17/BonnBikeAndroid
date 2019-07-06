package de.cseh17.bikesharing.bonnbike;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;

class CheckConnection {
    static boolean isConnected(ConnectivityManager cm){
        Network network = cm.getActiveNetwork();
        NetworkCapabilities mNetworkCapabilities= cm.getNetworkCapabilities(network);
        boolean isConnected = false;
        assert mNetworkCapabilities != null : "NetworkCapabilities error";
        if (network == null) {
            Log.i("Connected to:", "no connection");
            isConnected = false;
        } else {
            if (mNetworkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || mNetworkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)){
                Log.i("Connected to", "network");
                isConnected = true;
            }
        }
        return isConnected;
    }
}
