package ru.ridewithme.testapp;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by idbolshakov on 27.02.16.
 */
public abstract class EventsListActivityPrototype extends AppCompatActivity implements
        Response.Listener<JSONObject>,
        Response.ErrorListener,
        SwipeRefreshLayout.OnRefreshListener,
        OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    };

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onRefresh() {

    }

    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {

    }

}
