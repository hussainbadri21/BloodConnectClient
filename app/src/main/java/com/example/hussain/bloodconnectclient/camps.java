package com.example.hussain.bloodconnectclient;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class camps extends Activity {

    String[] campArray = {"Kolkata", "Chennai", "Bangalore", "Mumbai", "Delhi", "Hyderabad", "Lucknow", "Pune"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_camp);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_list, campArray);

        ListView listView = (ListView) findViewById(R.id.camp_list);
        listView.setAdapter(adapter);
    }
}
