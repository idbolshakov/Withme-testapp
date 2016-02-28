package ru.ridewithme.testapp.model;

import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by idbolshakov on 28.02.16.
 */
public abstract class ModelPrototype {

    // СВОЙСТВА

    public final static String EXTRA_EVENT_ID                    = "ru.ridewithme.testapp.EVENT_ID";
    public final static String EXTRA_EVENT_TITLE                 = "ru.ridewithme.testapp.EVENT_TITLE";
    public final static String EXTRA_EVENT_BEGIN_DATETIME        = "ru.ridewithme.testapp.EVENT_BEGIN_DATETIME";
    public final static String EXTRA_EVENT_END_DATETIME          = "ru.ridewithme.testapp.EVENT_END_DATETIME";

    public final static String EXTRA_PLACE_ID                    = "ru.ridewithme.testapp.PLACE_ID";
    public final static String EXTRA_PLACE_TITLE                 = "ru.ridewithme.testapp.PLACE_TITLE";
    public final static String EXTRA_PLACE_LATITUDE              = "ru.ridewithme.testapp.PLACE_LATITUDE";
    public final static String EXTRA_PLACE_LONGITUDE             = "ru.ridewithme.testapp.PLACE_LONGITUDE";
    public final static String EXTRA_PLACE_DESCRIPTION           = "ru.ridewithme.testapp.PLACE_DESCRIPTION";

    public final static String EXTRA_EVENT_MAX_PEOPLE            = "ru.ridewithme.testapp.EVENT_MAX_PEOPLE";
    public final static String EXTRA_EVENT_AMOUNT_OF_FOLLOWERS   = "ru.ridewithme.testapp.EVENT_AMOUNT_OF_FOLLOWERS";
    public final static String EXTRA_EVENT_SPORT_NAME            = "ru.ridewithme.testapp.EVENT_SPORT_NAME";
    public final static String EXTRA_EVENT_SPORT_IMAGE_URL       = "ru.ridewithme.testapp.EVENT_SPORT_IMAGE_URL";



    // КОНСТРУКТОР

    public ModelPrototype() {

    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public void putExtras(Intent intent, Event event) { // сериализация

        intent.putExtra(EXTRA_EVENT_ID,                    event.getId());
        intent.putExtra(EXTRA_EVENT_TITLE,                 event.getTitle());
        intent.putExtra(EXTRA_EVENT_BEGIN_DATETIME,        event.getBeginDatetime());
        intent.putExtra(EXTRA_EVENT_END_DATETIME,          event.getEndDatetime());

        intent.putExtra(EXTRA_PLACE_ID,                    event.getPlace().getId());
        intent.putExtra(EXTRA_PLACE_TITLE,                 event.getPlace().getTitle());
        intent.putExtra(EXTRA_PLACE_LATITUDE,              event.getPlace().getLatitude());
        intent.putExtra(EXTRA_PLACE_LONGITUDE,             event.getPlace().getLongitude());
        intent.putExtra(EXTRA_PLACE_DESCRIPTION,           event.getPlace().getDescription());

        intent.putExtra(EXTRA_EVENT_MAX_PEOPLE,            event.getMaxPeople());
        intent.putExtra(EXTRA_EVENT_AMOUNT_OF_FOLLOWERS,   event.getAmountOfFollowers());
        intent.putExtra(EXTRA_EVENT_SPORT_NAME,            event.getSportName());
        intent.putExtra(EXTRA_EVENT_SPORT_IMAGE_URL,       event.getSportImageURL());
    }

    public Event takeExtras(Intent intent) { // десериализация

        Event event = new Event(
                intent.getIntExtra(EXTRA_EVENT_ID, 0),
                intent.getStringExtra(EXTRA_EVENT_TITLE),
                intent.getStringExtra(EXTRA_EVENT_BEGIN_DATETIME),
                intent.getStringExtra(EXTRA_EVENT_END_DATETIME),

                new Place(
                        intent.getIntExtra(EXTRA_PLACE_ID, 0),
                        intent.getStringExtra(EXTRA_PLACE_TITLE),
                        intent.getDoubleExtra(EXTRA_PLACE_LATITUDE, 0),
                        intent.getDoubleExtra(EXTRA_PLACE_LONGITUDE, 0),
                        intent.getStringExtra(EXTRA_PLACE_DESCRIPTION)
                ),

                intent.getIntExtra(EXTRA_EVENT_MAX_PEOPLE, 0),
                intent.getIntExtra(EXTRA_EVENT_AMOUNT_OF_FOLLOWERS, 0),
                intent.getStringExtra(EXTRA_EVENT_SPORT_NAME),
                intent.getStringExtra(EXTRA_EVENT_SPORT_IMAGE_URL)
        );

        return event;
    }
}
