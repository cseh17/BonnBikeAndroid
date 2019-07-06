package de.cseh17.bikesharing.bonnbike;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import de.cseh17.bikesharing.bonnbike.BikeModel.Place;

/* Create a custom ClusterRandere in order to be able to customize the single markers displayed onto the map.
In this custom renderer class it is needed to override the OnBeforeClusterItemRendered method.
In there the marker changes are to be made */

public class CustomClusterManager extends DefaultClusterRenderer<Place> {

    public CustomClusterManager(Context context, GoogleMap map, ClusterManager<Place> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(Place item, MarkerOptions mMarkerOptions){

        if (item.getBike()){
            mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        } else {
            mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        }
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster cluster){
        return cluster.getSize() > 3;
    }
}
