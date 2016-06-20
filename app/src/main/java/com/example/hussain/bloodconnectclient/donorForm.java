package com.example.hussain.bloodconnectclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class donorForm extends Activity {
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button submitButton;
    Spinner spinner;
    private String URL_NEW_PREDICTION = "http://blloodconnect.net16.net/donor_phpcode.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dnor_form);
        ed1 = (EditText) findViewById(R.id.editText1);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);
        ed5 = (EditText) findViewById(R.id.editText5);
        ed6 = (EditText) findViewById(R.id.editText6);

        sp();

    }

    public void sp() {
        spinner = (Spinner) findViewById(R.id.spinner1);

        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        List<String> categories = new ArrayList<String>();

        categories.add("A+ve");
        categories.add("A-ve");
        categories.add("B+ve");
        categories.add("B-ve");
        categories.add("AB+ve");
        categories.add("AB-ve");
        categories.add("O+ve");
        categories.add("O-ve");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

    }
}
