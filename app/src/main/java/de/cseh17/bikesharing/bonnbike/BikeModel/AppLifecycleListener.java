package de.cseh17.bikesharing.bonnbike.BikeModel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class AppLifecycleListener implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public static boolean onMoveToForerground(){
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public static boolean onMoveToBackground(){
        return true;
    }
}
