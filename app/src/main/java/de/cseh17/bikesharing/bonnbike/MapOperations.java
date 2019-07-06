package de.cseh17.bikesharing.bonnbike;

import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.LinkedList;
import java.util.List;

import de.cseh17.bikesharing.bonnbike.NetworkAreaModel.Feature;

class MapOperations {

    private static List<List<Double>> rawPolygonPoints;
    private static LinkedList<LatLng> finalPolygonPoints = new LinkedList<>();

    static void drawPolygonOntoMap(GoogleMap mMap, List<Feature> rawNetworkAreaData){

        // If there are more areas for one network, iterate trough all of the areas and draw them onto the map
        for (Feature item : rawNetworkAreaData) {

            // Clear the finalPolygonPoints List after every run, in order to separate the polygons from each other
            finalPolygonPoints.clear();

            // Get the raw data of the polygons
            rawPolygonPoints = item.getGeometry().getCoordinates().get(0);

            // Convert the raw polygon data into LatLng format and save it into a new final List that will be used for drawing the polygon
            for (List<Double> point : rawPolygonPoints) {

                // By creating the LatLng coordinates it is important to interchange the coordinates, as they are delivered in the wrong non-standard order
                finalPolygonPoints.add(new LatLng(point.get(1), point.get(0)));
            }

            // Draw and and the polyfon to the map
            Polygon mapPolygon = mMap.addPolygon(new PolygonOptions()
                    .addAll(finalPolygonPoints)
                    .strokeColor(Color.parseColor(item.getProperties().getColor())));
        }
    }
}
