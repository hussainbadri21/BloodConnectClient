package com.example.hussain.bloodconnectclient;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttons();
    }
public void buttons()
    {
  Button button=(Button)findViewById(R.id.btlogin);

            button.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        EditText txtuser = (EditText) findViewById(R.id.txt_user);
                        EditText txtpwd = (EditText) findViewById(R.id.txt_pwd);
                        String user = txtuser.getText().toString();
                        String pass = txtpwd.getText().toString();
                        if (txtuser.length() == 0 || txtpwd.length() == 0)
                            Toast.makeText(LoginActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                        else
                        {

                       if(user.equalsIgnoreCase("admin")==false)
                            Toast.makeText(getApplicationContext(), "Incorrect Username", Toast.LENGTH_SHORT)
                                    .show();
                        if(pass.equalsIgnoreCase("admin")==false)
                            Toast.makeText(getApplicationContext(), "Incorrect Password", Toast.LENGTH_SHORT)
                                    .show();

                        if (user.equalsIgnoreCase("admin") == true && pass.equalsIgnoreCase("admin") == true) {
                            Toast.makeText(getApplicationContext(), "Login Sucessful!", Toast.LENGTH_SHORT)
                                    .show();
                            Intent intent = new Intent(LoginActivity.this, camps.class);
                            startActivity(intent);
                       }

                            //finish();
                        }


                    }
                });
        }
}









