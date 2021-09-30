package com.example.homeworka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;


public class Settings extends AppCompatActivity {

    protected TextView counter1_name;
    protected EditText counter1_info;
    protected TextView counter2_name;
    protected EditText counter2_info;
    protected TextView counter3_name;
    protected EditText counter3_info;
    protected TextView max_counts;
    protected EditText max_counts_info;
    protected Button button_save;
    private SharedPreferenceHelper sharedPreferenceHelper;
    String key1 = "1";
    String key2  = "2";
    String key3 = "3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        goToUISetup();
        sharedPreferenceHelper = new SharedPreferenceHelper(Settings.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
                case R.id.icon_action:{
                    goToEnable();
                    return true;
            }
            case R.id.home:{
                goToMain();
                return true;
            }
            default:return super.onOptionsItemSelected(item);
        }

    }
        private void goToUISetup () {

            counter1_name = findViewById(R.id.counter1_name);
            counter1_info = findViewById(R.id.counter1_info);
            counter2_name = findViewById(R.id.counter2_name);
            counter2_info = findViewById(R.id.counter2_info);
            counter3_name = findViewById(R.id.counter3_name);
            counter3_info = findViewById(R.id.counter3_info);
            max_counts = findViewById(R.id.max_counts);
            max_counts_info = findViewById(R.id.max_counts_info);
            button_save = findViewById(R.id.button_save);
            Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
            goToDisable();

            setSupportActionBar(toolbar1);
            //getSupportActionBar().setDisplayShowHomeEnabled(true);

            View.OnClickListener saving = new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String profileName1 = counter1_info.getText().toString();
                    sharedPreferenceHelper.setProfileName1(profileName1);

                    //goToChangeName3(profileName3);
                    goToDisable();
                    counter1_info.setText(sharedPreferenceHelper.getName1());
                }
            };


            button_save.setOnClickListener(saving);

        }

    private String getNameInfo(String key) {
       String name = sharedPreferenceHelper.getProfileName(key);
       return name;
        //placeholder for returning the name
    }

    private Integer getCountInfo() {
        return 123;
        //placeholder for returning the name
    }


    private void goToChangeMaxCount(Integer count_max) {
        sharedPreferenceHelper.setMaxCounter(count_max);
    }

    private void goToEnable() {
        counter1_info.setEnabled(true);
        counter2_info.setEnabled(true);
        counter3_info.setEnabled(true);
        max_counts_info.setEnabled(true);
    }

    private void goToDisable() {
        counter1_info.setEnabled(false);
        counter2_info.setEnabled(false);
        counter3_info.setEnabled(false);
        max_counts_info.setEnabled(false);
    }

    private void goToChangeNames(String key, String name) {
        sharedPreferenceHelper.setProfileName(key, name);
    }

    private void goToChangeName1(String name) {
        sharedPreferenceHelper.setProfileName1(name);
    }

    private void goToChangeName2(String name) {
        sharedPreferenceHelper.setProfileName2( name);
    }

    private void goToChangeName3(String name) {
        sharedPreferenceHelper.setProfileName3( name);
    }



    private void goToMain() {
        Intent intent = new Intent  (this, MainActivity.class);
        startActivity(intent);
    };

}