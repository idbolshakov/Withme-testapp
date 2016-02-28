package ru.ridewithme.testapp.model.eventslistactivity;


import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ru.ridewithme.testapp.EventsListActivity;
import ru.ridewithme.testapp.VolleySingleton;
import ru.ridewithme.testapp.model.Event;
import ru.ridewithme.testapp.model.ModelPrototype;
import ru.ridewithme.testapp.model.Place;

/**
 * Created by idbolshakov on 27.02.16.
 *
 * Получение, хранение и работа с данными о событиях Withme
 */
public class Model extends ModelPrototype{

    // СВОЙСТВА

    private final static String requestURL = "http://dev.ridewithme.ru/feed.php?Radius=world&Feed=11";

    private ArrayList<Event> events = new ArrayList<Event>();

    private EventsListActivity activity;



    // КОНСТРУКТОР

    public Model(EventsListActivity activity) {

        super();

        this.activity = activity;

        fetchJSON(); // отправляем запрос на получение JSON данных о событиях
    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public ArrayList<Event> getEvents() {

        return this.events;
    }


    public void parseJSON(JSONObject response) {

        try {

            JSONObject jsonEvents = response.getJSONObject("EventsArray"); // JSON ответ сервера

            JSONObject currJSONEvent; // сюда будем вытаскивать новое событие в JSON формате

            JSONObject currJSONPlace; // информация о месте проведения события в JSON

            Event event; // сюда будем парсить новое событие из JSON

            events.clear();  // очищаем предыдущий список событий

            for ( int i = 0 ; i < jsonEvents.names().length() ; i++ ) {

                currJSONEvent = jsonEvents.getJSONObject(jsonEvents.names().getString(i));

                currJSONPlace = currJSONEvent.getJSONObject("EventPlace");

                event = new Event(
                        Integer.parseInt(currJSONEvent.getString("EventID")),
                        currJSONEvent.getString("EventTitle"),
                        currJSONEvent.getString("EventBeginDatetime"),
                        currJSONEvent.getString("EventEndDatetime"),
                        new Place(
                                checkIntValueOnNull(currJSONPlace.getString("PlaceID")),
                                currJSONPlace.getString("PlaceTitle"),
                                Double.parseDouble(currJSONPlace.getString("PlaceLatitude")),
                                Double.parseDouble(currJSONPlace.getString("PlaceLongitude")),
                                currJSONPlace.getString("PlaceDescription")
                        ),
                        checkIntValueOnNull(currJSONEvent.getString("EventMaxPeople")),
                        checkIntValueOnNull(currJSONEvent.getString("EventAmountOfFollowers")),
                        currJSONEvent.getString("SportName"),
                        currJSONEvent.getString("SportImageURL")
                );

                this.events.add(event);
            }

            // сортируем события по ID
            Collections.sort(events);

        } catch (JSONException e) {

            e.printStackTrace();
            Toast.makeText(activity.getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public void fetchJSON() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, requestURL, null, activity, activity);

        VolleySingleton.getInstance().addToRequestQueue(request);
    }


    // РЕАЛИЗАЦИЯ КЛАССА (PUBLIC МЕТОДЫ)

    private int checkIntValueOnNull(String value) {

        if (value == "null") {
            return 0;
        }

        return Integer.parseInt(value);
    }

}
