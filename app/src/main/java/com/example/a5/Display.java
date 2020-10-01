package com.example.a5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        final ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.displayActivity);
        final TextView userNameText = (TextView) findViewById(R.id.usernameText);
        final Spinner bgColorSpinner = (Spinner) findViewById(R.id.bgColorSpinner);
        final Button setColorBt = (Button) findViewById(R.id.setColorBt);
        final Button logoutBt = (Button) findViewById(R.id.logoutBt);

        SharedPreferences myprefs=getSharedPreferences("exp5prefs",MODE_PRIVATE);


        String prefBgColor = myprefs.getString("bgColor", "");
        String username = myprefs.getString("username", "");

        userNameText.setText(username);

        if(prefBgColor.equals("Red")) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.Red));
        } else if (prefBgColor.equals("Green")) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.Green));
        } else if (prefBgColor.equals("Brown")) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.Brown));
        } else if (prefBgColor.equals("Yellow")) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.Yellow));
        } else if (prefBgColor.equals("Blue")) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.Blue));
        } else if (prefBgColor.equals("Purple")) {
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.Purple));
        }

        ArrayList<String> spinnerList = new ArrayList<>();
        spinnerList.add("Red");
        spinnerList.add("Green");
        spinnerList.add("Brown");
        spinnerList.add("Yellow");
        spinnerList.add("Blue");
        spinnerList.add("Purple");

        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        myArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bgColorSpinner.setAdapter(myArrayAdapter);
        bgColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                data = myArrayAdapter.getItem(position);
            }

            @Override public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        setColorBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                SharedPreferences myprefs=getSharedPreferences("exp5prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = myprefs.edit();
                editor.putString("bgColor", data);
                editor.apply();

                if(data.equals("Red")) {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.Red));
                } else if (data.equals("Green")) {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.Green));
                } else if (data.equals("Brown")) {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.Brown));
                } else if (data.equals("Yellow")) {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.Yellow));
                } else if (data.equals("Blue")) {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.Blue));
                } else if (data.equals("Purple")) {
                    constraintLayout.setBackgroundColor(getResources().getColor(R.color.Purple));
                }
            }
        });

        logoutBt.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(Display.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
