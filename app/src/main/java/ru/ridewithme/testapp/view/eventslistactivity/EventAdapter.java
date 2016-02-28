package ru.ridewithme.testapp.view.eventslistactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ru.ridewithme.testapp.R;
import ru.ridewithme.testapp.model.Event;

/**
 * Created by idbolshakov on 26.02.16.
 *
 * Кастомизированный адаптер ListView списка событий Witme
 */
public class EventAdapter extends ArrayAdapter<Event> {

    // СВОЙСТВА

    private ArrayList<Event> events; // список событий, передаваемый адаптеру
    private Context context; // контект выполнения



    // КОНСТРУКТОР

    public EventAdapter(Context context, int listViewResourceId, ArrayList<Event> events) {

        super(context, listViewResourceId, events);

        this.events = events;

        this.context = context;
    }



    // ИНТЕРФЕЙС КЛАССА (PUBLIC МЕТОДЫ)

    public View getView(int position, View convertView, ViewGroup parent) {

        // получение шаблона listView итема
        View item = convertView;

        EventViewHolder holder = null;

        if (item==null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = inflater.inflate(R.layout.activity_events_list_item, null);

            holder = new EventViewHolder();
            holder.eventTitle = (TextView) item.findViewById(R.id.eventTitle);
            holder.sportTitle = (TextView) item.findViewById(R.id.sportName);
            holder.eventPlace = (TextView) item.findViewById(R.id.eventPlaceText);
            holder.eventStartTime = (TextView) item.findViewById(R.id.startTimeText);
            holder.eventGroup = (TextView) item.findViewById(R.id.groupText);
            holder.sportImage = (ImageView) item.findViewById(R.id.sportImage);

            item.setTag(holder);

        } else {

            holder = (EventViewHolder) item.getTag();
        }

        // формирование ListView итема

        Event event = events.get(position);

        // формирование TextView шаблона
        holder.eventTitle.setText(event.getTitle());
        holder.sportTitle.setText(event.getSportName());
        holder.eventPlace.setText(event.getPlace().getTitle());
        holder.eventStartTime.setText(event.getBeginDatetime());
        holder.eventGroup.setText(event.getGroupInfo());

        // загрузка изображения вида спорта, испoльзуя Picasso
        Picasso.with(context).load(event.getSportImageURL()).placeholder(R.drawable.rounded_frame).into(holder.sportImage);

        return item;
    }



    // ВНУТРЕННИЕ КЛАССЫ

    /**
     *
     *  Необходим для реализации паттерна Custom ArrayAdapter ViewHolder
     */
    private static class EventViewHolder {

        TextView eventTitle;
        TextView sportTitle;
        TextView eventPlace;
        TextView eventStartTime;
        TextView eventGroup;

        ImageView sportImage;


    }
}
