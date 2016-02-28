package ru.ridewithme.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import ru.ridewithme.testapp.model.Event;
import ru.ridewithme.testapp.model.eventinfoactivity.Model;
import ru.ridewithme.testapp.view.eventinfoactivity.View;


/**
 * Created by idbolshakov on 27.02.16.
 */
public class EventInfoActivity extends EventInfoActivityPrototype {

    // СВОЙСТВА

    private Model model; // хранит данные о событии и методы для работы с ним
    private View view; //  визуализация модели



    // INTERFACES CALLBACK МЕТОДЫ

    /**
     * СТАРТ АКТИВИТИ
     *
     * инициализация модели и представления
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        // инициализация модели
        this.model = new Model(this.getIntent());

        // инициализация представления (связываем модель с представлением)
        this.view = new View(this, model.getEvent());

    }


    /**
     * ON RESUME
     *
     *  отправляем запрос  на получении google карты
     */
    @Override
    protected void onResume() {
        super.onResume();

        this.view.getGoogleMap(this);
    }


    /**
     * КАРТА ГОТОВА К ПОКАЗУ
     *
     * добавляем метку на место проведения события WITHME
     *
     * @param map
     */
    @Override
    public void onMapReady(GoogleMap map) {

        this.view.showEventOnMap(map, model.getEvent());
    }


    /**
     * КАРТА ОТРЕНДЕРИЛАСЬ И ГОТОВА К ПОКАЗУ
     *
     * скрываем лоадер карты
     *
     */
    @Override
    public void onMapLoaded() {

        this.view.hideMapLoadingPanel();
    }


    /**
     * ПОЛЬЗОВАТЕЛЬ КЛИКНУЛ НА КАРТУ
     *
     * открываем карту на новом activity
     *
     */
    public void onMapClick(android.view.View view) {

        Intent intent = new Intent(this, EventMapActivity.class);

       this.model.putExtras(intent, this.model.getEvent());

       startActivity(intent);
    }

}

