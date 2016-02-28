package ru.ridewithme.testapp;

import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;

import ru.ridewithme.testapp.model.eventmapactivity.Model;
import ru.ridewithme.testapp.view.eventsMapActivity.View;


/**
 * Created by idbolshakov on 27.02.16.
 */
public class EventMapActivity extends EventMapActivityPrototype {

    // СВОЙСТВА

    private Model model; // хранит данные о событии и методы для работы с ним
    private View  view; //  визуализация модели



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
        setContentView(R.layout.activity_event_map);

        // инициализация модели
        this.model = new Model(this.getIntent());

        // инициализация представления (связываем модель с представлением)
        this.view = new View(this, this.model.getEvent());

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

}

