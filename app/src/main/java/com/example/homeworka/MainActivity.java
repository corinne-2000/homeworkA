package com.example.homeworka;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected Button button_eventA;
    protected Button button_eventB;
    protected Button button_eventC;
    protected Button button_count;
    protected Button button_settings;
    protected TextView textview_count;
    private SharedPreferenceHelper sharedPreferenceHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToUISetup();
        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);
    }
    private void goToUISetup() {

        textview_count = findViewById(R.id.textview_count);
        button_eventA = findViewById(R.id.button_eventA);
        button_eventB = findViewById(R.id.button_eventB);
        button_eventC = findViewById(R.id.button_eventC);
        button_count = findViewById(R.id.button_count);
        button_settings = findViewById(R.id.button_settings);



        SharedPreferences myPrefs = getApplicationContext().getSharedPreferences("ProfilePreference", MODE_PRIVATE);


        String eAName = myPrefs.getString("profileName1", "");
        String eBName = myPrefs.getString("profileName2", "");
        String eCName = myPrefs.getString("profileName3", "");

        if (eAName != ""){
            button_eventA.setText(eAName);
        }
        if (eBName != ""){
            button_eventB.setText(eBName);
        }
        if (eCName != ""){
            button_eventC.setText(eCName);
        }

        View.OnClickListener events = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToIncreseAllCounts();
                textview_count.setText(textviewCountUpdater());
                switch (view.getId()) {
                    case R.id.button_eventA:
                        sharedPreferenceHelper.setIncreaseA();
                        sharedPreferenceHelper.goToAddName(button_eventA);
                        break;
                    case R.id.button_eventB:
                        sharedPreferenceHelper.setIncreaseB();
                        sharedPreferenceHelper.goToAddName(button_eventB);
                        break;
                    case R.id.button_eventC:
                        sharedPreferenceHelper.setIncreaseC();
                        sharedPreferenceHelper.goToAddName(button_eventC);
                        break;
                }

               // String info = myPrefs.getString("profileName1", "") + "hi";
                Toast tost= Toast.makeText(getApplicationContext(), eAName, Toast.LENGTH_LONG);
                tost.show();
            }
        };

        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSettings();
            }
        });

        button_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCount();
            }
        });

        button_eventA.setOnClickListener(events);
        button_eventB.setOnClickListener(events);
        button_eventC.setOnClickListener(events);
    }

    private String textviewCountUpdater() {
        String stringofCount = getString(R.string.numberOfCountsPhrase);
        String countPhrase = stringofCount + getAllIncrements();
        return countPhrase;
    }

    private void goToIncreseEachCount(Integer counterForSpecificEvent) {
        sharedPreferenceHelper.setIncreaseCountEachEvent(counterForSpecificEvent);
    };

    private void goToIncreseAllCounts() {
      sharedPreferenceHelper.setIncreaseCountForAllEvents();
    };

  private int getAllIncrements (){
      int numberOfCounts = sharedPreferenceHelper.getCountofAllEvents();
      return numberOfCounts;
  };
    private void goToCount() {
        Intent intent = new Intent  (this, Count.class);
        startActivity(intent);
    };

    private void goToSettings() {
        Intent intent = new Intent  (this, Settings.class);
        startActivity(intent);
    };
}