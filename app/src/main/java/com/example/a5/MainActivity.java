package com.example.a5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences myprefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myprefs=getSharedPreferences("exp5prefs",MODE_PRIVATE);
        final EditText username = (EditText) findViewById(R.id.usernameEdit);
        final EditText password = (EditText) findViewById(R.id.passwordEdit);
        final CheckBox rememberCred = (CheckBox) findViewById(R.id.rememberCred);
        final Button loginBt = (Button) findViewById(R.id.loginBt);

        if (myprefs.getBoolean("rememberUser",false)) {
            username.setText(myprefs.getString("username", ""));
            password.setText(myprefs.getString("password", ""));
        }

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("aa")  && pass.equals("12")) {
                    SharedPreferences.Editor editor = myprefs.edit();
                    editor.putBoolean("rememberUser",rememberCred.isChecked());

                    if (rememberCred.isChecked()) {
                        editor.putString("username",user);
                        editor.putString("password",pass);
                    }

                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, Display.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid UserName/PassWord", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
