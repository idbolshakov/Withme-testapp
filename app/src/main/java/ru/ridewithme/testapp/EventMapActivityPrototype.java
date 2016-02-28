package ru.ridewithme.testapp;

import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by idbolshakov on 28.02.16.
 */
public abstract class EventMapActivityPrototype extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback {

    @Override
    public void onMapReady(GoogleMap map) {
    }

    @Override
    public void onMapLoaded() {
    }
}
