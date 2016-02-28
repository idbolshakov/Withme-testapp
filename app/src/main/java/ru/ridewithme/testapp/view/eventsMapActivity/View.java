package ru.ridewithme.testapp.view.eventsMapActivity;

import android.content.Intent;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ru.ridewithme.testapp.EventMapActivity;
import ru.ridewithme.testapp.R;
import ru.ridewithme.testapp.model.Event;

/**
 * Created by idbolshakov on 28.02.16.
 */
public class View {

    // СВОЙСТВА

    private EventMapActivity activity;

    // КОНСТРУКТОР

    public View(EventMapActivity activity, Event event) {

        super();

        this.activity = activity;

        this.activity.setTitle(event.getTitle());

    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public void showEventOnMap(GoogleMap map, Event event) {

        LatLng position = new LatLng(event.getPlace().getLatitude(), event.getPlace().getLongitude());

        // map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 13));

        map.addMarker(new MarkerOptions().position(position).title(event.getPlace().getTitle()).snippet(event.getPlace().getDescription()));

        map.setOnMapLoadedCallback(this.activity);
    }


    public void getGoogleMap(EventMapActivity activity) {

        MapFragment mapFragment = (MapFragment) activity.getFragmentManager().findFragmentById(R.id.fullScreenMap);

        mapFragment.getMapAsync(activity);
    }

}
