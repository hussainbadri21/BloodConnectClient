package com.example.hussain.bloodconnectclient;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;

public class camp2 extends Activity {

    String[] campArray = {"Camp 1","Camp 2","Camp 3","Camp 4","Camp 5","Camp 6","Camp 7","Camp 8"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_camp2);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, campArray);

        listView = (ListView) findViewById(R.id.camp_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        parent.getItemAtPosition(position) + "  is selected.", Toast.LENGTH_LONG)
                        .show();
                Intent intent = new Intent(camp2.this, donorForm.class);

                startActivity(intent);
            }

        });



    }
}
