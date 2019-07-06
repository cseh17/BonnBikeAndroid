package de.cseh17.bikesharing.bonnbike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import de.cseh17.bikesharing.bonnbike.BikeModel.Place;

/* Create a custom InfoWindow that implements the default GoogleMapsInfoWindowAdapter,
in order to be able to display custom bike & rack information like name, image, available bikes etc.
The custom InfoWindow implements a title, an image, and 2 snippets.
 */

public class CustomBikeAndRackInfoWindow implements GoogleMap.InfoWindowAdapter {

    private final View customBikeAndRackInfoWindowView;
    private static Place clickedClusterItem;

    CustomBikeAndRackInfoWindow(Context mContext) {
        customBikeAndRackInfoWindowView = LayoutInflater.from(mContext).inflate(R.layout.custom_bike_and_rack_info_window, null);
    }

    // Method that gets the selected marker in order to be able to display the current marker information.
    static void getCurrentSelectedItem(Place mClickedClusterItem) {
        clickedClusterItem = mClickedClusterItem;
    }

    @Override
    public View getInfoWindow(Marker marker) {

        // Set InfoWindow title
        TextView ciwTitleTv = customBikeAndRackInfoWindowView.findViewById(R.id.ciw_title);
        ciwTitleTv.setText( clickedClusterItem.getName());
        customBikeAndRackInfoWindowView.setClickable(false);
        return customBikeAndRackInfoWindowView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
