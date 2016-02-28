package ru.ridewithme.testapp.view.eventslistactivity;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import ru.ridewithme.testapp.EventsListActivityPrototype;
import ru.ridewithme.testapp.R;
import ru.ridewithme.testapp.model.Event;

/**
 * Created by idbolshakov on 27.02.16.
 */
public class View {

    // СВОЙСТВА

    private EventAdapter eventsAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EventsListActivityPrototype activity;



    // КОНСТРУКТОР

    public View(EventsListActivityPrototype activity, ArrayList<Event> events ) {

        super();

        this.activity = activity;

        setAdapterToListView(events, activity);

        setSwipeToRefreshListener(activity);

    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ

    public void refreshEventsInfo() {

        eventsAdapter.notifyDataSetChanged(); // обновляем ListView

        setSwipeRefreshLayoutRefreshed();

        hideCentreLoadingPanel();
    }



    // РЕАЛИЗАЦИЯ КЛАССА (PRIVATE МЕТОДЫ)

    private void setAdapterToListView(ArrayList<Event> events, EventsListActivityPrototype activity) {

        ListView listView = (ListView) activity.findViewById(R.id.eventsList);


        eventsAdapter = new EventAdapter(activity, R.layout.activity_events_list_item, events);

        listView.setAdapter(eventsAdapter);

        listView.setOnItemClickListener(activity);

    }


    private void setSwipeToRefreshListener(EventsListActivityPrototype activity) {

        swipeRefreshLayout = (SwipeRefreshLayout) activity.findViewById(R.id.swiperefresh);

        swipeRefreshLayout.setOnRefreshListener(activity);
    }

    private void setSwipeRefreshLayoutRefreshed() {

        swipeRefreshLayout.setRefreshing(false);
    }


    private void hideCentreLoadingPanel() {

        RelativeLayout centreLoadingPanel = (RelativeLayout) this.activity.findViewById(R.id.centerLoadingPanel);

        centreLoadingPanel.setVisibility(android.view.View.INVISIBLE);
    }


    private void showCentreLoadingPanel() {

        RelativeLayout centreLoadingPanel = (RelativeLayout) activity.findViewById(R.id.centerLoadingPanel);

        centreLoadingPanel.setVisibility(android.view.View.VISIBLE);
    }

}
