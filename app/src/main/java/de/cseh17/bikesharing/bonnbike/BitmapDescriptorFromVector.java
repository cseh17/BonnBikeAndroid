package de.cseh17.bikesharing.bonnbike;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class BitmapDescriptorFromVector {

    static BitmapDescriptor bitmapDescriptorFromVector(Context mContext, int vectorResId){
        Drawable vectorDrawable = ContextCompat.getDrawable(mContext, vectorResId);
        assert vectorDrawable != null : "No Vector drawable was found";
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap mBitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        vectorDrawable.draw(mCanvas);
        return BitmapDescriptorFactory.fromBitmap(mBitmap);
    }
}
