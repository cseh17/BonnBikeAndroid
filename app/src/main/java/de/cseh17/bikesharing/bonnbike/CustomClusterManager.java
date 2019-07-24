package de.cseh17.bikesharing.bonnbike;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
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

    private Context mContext;

    CustomClusterManager(Context context, GoogleMap map, ClusterManager<Place> clusterManager) {
        super(context, map, clusterManager);
        mContext = context;
    }

    @Override
    protected void onBeforeClusterItemRendered(Place item, MarkerOptions mMarkerOptions){

        if (item.getBike()){
            mMarkerOptions.icon(BitmapDescriptorFromVector.bitmapDescriptorFromVector(mContext, R.drawable.ic_bonnbikemarkerbike));
        } else {
            if (item.getBikes() != 0) {
                mMarkerOptions.icon(BitmapDescriptorFromVector.bitmapDescriptorFromVector(mContext, R.drawable.ic_bonnbikemarkerstation));
            } else {
                mMarkerOptions.icon(BitmapDescriptorFromVector.bitmapDescriptorFromVector(mContext, R.drawable.ic_bonnbikemarkerstationoff));
            }
        }
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster cluster){
        return cluster.getSize() > 3;
    }
}
