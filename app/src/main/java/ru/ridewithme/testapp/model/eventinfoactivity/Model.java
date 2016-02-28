package ru.ridewithme.testapp.model.eventinfoactivity;

import android.content.Intent;

import ru.ridewithme.testapp.model.Event;
import ru.ridewithme.testapp.model.ModelPrototype;
import ru.ridewithme.testapp.model.Place;

/**
 * Created by idbolshakov on 28.02.16.
 */
public class Model extends ModelPrototype {

    // СВОЙСТВА

    private Event event;




    // КОНСТРУКТОРЫ

    public Model() {
        super();
    }

    public Model(Intent intent) {

        super();

        this.event = takeExtras(intent);

    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public Event getEvent() { return this.event; }

}
