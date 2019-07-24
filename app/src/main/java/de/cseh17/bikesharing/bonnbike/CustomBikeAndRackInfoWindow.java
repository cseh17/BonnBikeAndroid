package de.cseh17.bikesharing.bonnbike;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private Context receivedContext;

    CustomBikeAndRackInfoWindow(Context mContext) {

        customBikeAndRackInfoWindowView = LayoutInflater.from(mContext).inflate(R.layout.custom_bike_and_rack_info_window, null);
        receivedContext = mContext;
    }

    // Method that gets the selected marker in order to be able to display the current marker information.
    static void getCurrentSelectedItem(Place mClickedClusterItem) {
        clickedClusterItem = mClickedClusterItem;
    }

    @Override
    public View getInfoWindow(Marker marker) {

        // Check if the marker is a bike or a rack, and configure it accordingly
        if (clickedClusterItem.getBike()) {

            // Set bike InfoWindow title
            TextView ciwTitleTv = customBikeAndRackInfoWindowView.findViewById(R.id.ciw_title);
            ciwTitleTv.setText(receivedContext.getString(R.string.custom_info_window_bike_name_title));
            ciwTitleTv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            // Set bike InfoWindow subtitle with bike CODE
            TextView ciwSubtitleTv = customBikeAndRackInfoWindowView.findViewById(R.id.ciw_subtitle);
            ciwSubtitleTv.setText(clickedClusterItem.getBikeNumbers().get(0));
            ciwSubtitleTv.setTextColor(Color.BLACK);
            ciwSubtitleTv.setTextSize(35);
            ciwSubtitleTv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            // Set the logo of the infoView window from the resources
            ImageView ciwImageView = customBikeAndRackInfoWindowView.findViewById(R.id.ciw_logo);
            ciwImageView.setImageResource(R.drawable.ic_bonnbike_bike);
        } else {

            // Set Rack nfoWindow title
            TextView ciwTitleTv = customBikeAndRackInfoWindowView.findViewById(R.id.ciw_title);
            ciwTitleTv.setText(clickedClusterItem.getName());
            ciwTitleTv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            // Set Rack subtitle with information like free racks and available bikes
            TextView ciwSubtitleTv = customBikeAndRackInfoWindowView.findViewById(R.id.ciw_subtitle);
            ciwSubtitleTv.setText(receivedContext.getString(R.string.custom_info_window_rack_available_bike_title) + clickedClusterItem.getBikes());
            ciwSubtitleTv.setTextColor(receivedContext.getColor(R.color.darkGreen));
            ciwSubtitleTv.setTextSize(18);
            ciwSubtitleTv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        }
        return customBikeAndRackInfoWindowView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
