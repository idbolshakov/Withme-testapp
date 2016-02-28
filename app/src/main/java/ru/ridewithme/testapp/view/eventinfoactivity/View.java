package ru.ridewithme.testapp.view.eventinfoactivity;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ru.ridewithme.testapp.EventInfoActivityPrototype;
import ru.ridewithme.testapp.R;
import ru.ridewithme.testapp.model.Event;
import ru.ridewithme.testapp.model.eventslistactivity.Model;

/**
 * Created by idbolshakov on 28.02.16.
 */
public class View {

    // СВОЙСТВА

    private EventInfoActivityPrototype activity;

    // КОНСТРУКТОР

    public View(EventInfoActivityPrototype activity, Event event) {

        super();

        this.activity = activity;

        showEventInfo(this.activity.getIntent(), event);

    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public void showEventOnMap(GoogleMap map, Event event) {

        LatLng position = new LatLng(event.getPlace().getLatitude(), event.getPlace().getLongitude());

        // map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 13));

        map.addMarker(new MarkerOptions().position(position));

        map.setOnMapLoadedCallback(this.activity);
    }


    public void getGoogleMap(EventInfoActivityPrototype activity) {

        MapFragment mapFragment = (MapFragment) activity.getFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(activity);
    }


    public void hideMapLoadingPanel() {

        LinearLayout centreLoadingPanel = (LinearLayout) this.activity.findViewById(R.id.mapLoadingPanel);

        centreLoadingPanel.setVisibility(android.view.View.INVISIBLE);
    }

    public void showMapLoadingPanel() {

        LinearLayout centreLoadingPanel = (LinearLayout) this.activity.findViewById(R.id.mapLoadingPanel);

    }



    // РЕАЛИЗАЦИЯ КЛАССА (PRIVATE МЕТОДЫ)

    private void showEventInfo(Intent intent, Event event) {

        this.activity.setTitle(event.getTitle());

        TextView eventDescription = (TextView) this.activity.findViewById(R.id.descriptionText);
        eventDescription.setText(event.getPlace().getDescription());

        TextView startTimeText = (TextView) this.activity.findViewById(R.id.startTimeText);
        startTimeText.setText(event.getBeginDatetime());

        TextView endTimeText = (TextView) this.activity.findViewById(R.id.endTimeText);
        endTimeText.setText(event.getEndDatetime());

        TextView placeInfo = (TextView) this.activity.findViewById(R.id.placeInfoText);
        placeInfo.setText(event.getPlace().getTitle());

    }


}
