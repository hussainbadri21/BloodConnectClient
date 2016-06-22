package com.example.hussain.bloodconnectclient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class donorForm extends Activity  implements AdapterView.OnItemSelectedListener {
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button submitButton;
    TextView tx;
    String donated;
    Spinner spinner;
    private String URL_NEW_PREDICTION = "http://blloodconnect.net16.net/donor_phpcode.php";
    RadioGroup rg1;
    RadioButton rb1;
    RadioButton rb2;
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
        tx=(TextView)findViewById(R.id.textView9);

        spinners();

        rg1=(RadioGroup)findViewById(R.id.myRadioGroup);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rb1.isChecked()) {
                    tx.setVisibility(View.VISIBLE);
                    ed6.setVisibility(View.VISIBLE);
                    donated="Yes";
                }
                if(rb2.isChecked()) {
                    tx.setVisibility(View.INVISIBLE);
                    ed6.setVisibility(View.INVISIBLE);
                    donated = "No";
                }
            }
        });



        submitButton=(Button)findViewById(R.id.submit) ;

submitButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name=ed1.getText().toString();
        String age=ed2.getText().toString();
        String adress=ed3.getText().toString();
        String height=ed4.getText().toString();
        String weight=ed5.getText().toString();
        String last;
        if(donated.equalsIgnoreCase("yes"))
            last=ed6.getText().toString();
        else
        last="NULL";
        String blood=spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();

        new AddNewPrediction().execute(name,age,adress,height,weight,blood,donated,last);
Toast.makeText(getApplicationContext(),"Data Submitted",Toast.LENGTH_SHORT).show();

    }
});

    }
    private class AddNewPrediction extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String... arg) {
            // TODO Auto-generated method stub
            String name = arg[0];
            String age = arg[1];
            String adress = arg[2];
            String height = arg[3];
            String weight = arg[4];
            String blood = arg[5];
            String donated = arg[6];
            String last = arg[7];


            // Preparing post params
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("name", name));
            params.add(new BasicNameValuePair("age", age));
            params.add(new BasicNameValuePair("adress", adress));
            params.add(new BasicNameValuePair("height", height));
            params.add(new BasicNameValuePair("weight", weight));
            params.add(new BasicNameValuePair("bloodType", blood));
            params.add(new BasicNameValuePair("donated", donated));
            params.add(new BasicNameValuePair("lastDonated", last));
            Sender serviceClient = new Sender();

            String json = serviceClient.makeServiceCall(URL_NEW_PREDICTION,
                    Sender.POST, params);

            Log.d("Create Prediction Request: ", "> " + json);

            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    boolean error = jsonObj.getBoolean("error");
                    // checking for error node in json
                    if (!error) {
                        // new category created successfully
                        Log.e("Prediction added successfully ",
                                "> " + jsonObj.getString("message"));
                    } else {
                        Log.e("Add Prediction Error: ",
                                "> " + jsonObj.getString("message"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Log.e("JSON Data", "JSON data error!");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }



    public void spinners() {
      spinner = (Spinner) findViewById(R.id.spinner1);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select");
        categories.add("A +ve");
        categories.add("A -ve");
        categories.add("B +ve");
        categories.add("B -ve");
        categories.add("AB +ve");
        categories.add("AB -ve");
        categories.add("O +ve");
        categories.add("O -ve");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
