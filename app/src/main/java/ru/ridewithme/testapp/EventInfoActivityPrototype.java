package ru.ridewithme.testapp;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;


/**
 * Created by idbolshakov on 28.02.16.
 */
public abstract class EventInfoActivityPrototype extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleMap.OnMapLoadedCallback {

    @Override
    public void onMapReady(GoogleMap map) {
    }

    @Override
    public void onMapLoaded() {
    }

}
