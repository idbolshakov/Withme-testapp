package ru.ridewithme.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;


import org.json.JSONObject;

import ru.ridewithme.testapp.model.eventslistactivity.Model;
import ru.ridewithme.testapp.view.eventslistactivity.View;

public class EventsListActivity extends EventsListActivityPrototype {

    // СВОЙСТВА

    private Model model; // хранит данные о событиях и методы для работы с ними
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
        setContentView(R.layout.activity_events_list);

        // инициализация модели
        this.model = new Model(this);

        // инициализация представления (связываем модель с представлением)
        this.view = new View(this, model.getEvents());

    }


    /**
     * ПОЛУЧЕНЫ JSON ДАННЫЕ С СЕРВЕРА
     *
     * Парсим JSON и обновляем данные в view
     *
     * @param response
     */
    @Override
    public void onResponse(JSONObject response) {

        this.model.parseJSON(response);

        this.view.refreshEventsInfo();
    }

    /**
     * ПРИ ПОЛУЧЕНИИ JSON произошла ошибка
     *
     * выыводим код ошибки в DialogView
     *
     * @param error
     */
    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
    }


    /**
     *  СРАБОТАЛ ВИДЖЕТ SWIPE TO REFRESH
     *
     *  отправляем новый запрос на получение JSON данных с сервера
     */
    @Override
    public void onRefresh() {

        this.model.fetchJSON();
    }


    /**
     * ПОЛЬЗОВАТЕЛЬ КЛИКНУЛ ПО СОБЫТИЮ В LIST VIEW
     *
     * Переходим на Event Info Activity
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick (AdapterView<?> parent, android.view.View view, int position, long id) {

        Intent intent = new Intent(this, EventInfoActivity.class);

        this.model.putExtras(intent, this.model.getEvents().get(position));

        startActivity(intent);
    }
}
