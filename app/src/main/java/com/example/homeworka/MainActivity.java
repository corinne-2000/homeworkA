package com.example.homeworka;

import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected Button button_eventA;
    protected Button button_eventB;
    protected Button button_eventC;
    protected Button button_count;
    protected Button button_settings;
    protected TextView textview_count;
    protected int incrementA  =0;
    protected int incrementB  =0;
    protected int incrementC = 0;
    private SharedPreferenceHelper sharedPreferenceHelper;
    public String key1 = "1";
    protected String key2 = "2";
    protected String key3 = "3";

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

      // button_eventA.setText(sharedPreferenceHelper.getName1());


        View.OnClickListener events = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToIncreseAllCounts();
                textview_count.setText(textviewCountUpdater());
                switch (view.getId()) {
                    case R.id.button_eventA:
                        goToIncreseEachCount(incrementA);
                        break;
                    case R.id.button_eventB:
                        goToIncreseEachCount(incrementB);
                        break;
                    case R.id.button_eventC:
                        goToIncreseEachCount(incrementC);
                        break;
                }
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
        String string = getString(R.string.numberOfCountsPhrase);
        String countPhrase = string + getAllIncrements();
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