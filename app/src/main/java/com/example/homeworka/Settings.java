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

    protected TextView counter1_name,counter2_name, counter3_name, max_counts;
    protected EditText counter1_info, counter2_info, counter3_info, max_counts_info;
    protected Button button_save;
    public SharedPreferenceHelper sharedPreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        goToUISetup();
        sharedPreferenceHelper = new SharedPreferenceHelper(Settings.this);

        counter1_info.setHint(R.string.hintEvents);
        counter2_info.setHint(R.string.hintEvents);
        counter3_info.setHint(R.string.hintEvents);
        max_counts_info.setHint(R.string.hintMax);
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


        View.OnClickListener saving = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String profileName1 = counter1_info.getText().toString();
                sharedPreferenceHelper.setProfileName1(profileName1);
                String profileName2 = counter2_info.getText().toString();
                sharedPreferenceHelper.setProfileName2(profileName2);
                String profileName3 = counter3_info.getText().toString();
                sharedPreferenceHelper.setProfileName3(profileName3);
                String maximumCount = max_counts_info.getText().toString();
                sharedPreferenceHelper.setMaxCounter(maximumCount);

                goToDisable();

                counter1_info.setText(sharedPreferenceHelper.getName1());
                counter2_info.setText(sharedPreferenceHelper.getName2());
                counter3_info.setText(sharedPreferenceHelper.getName3());
                max_counts_info.setText(sharedPreferenceHelper.getMaxCount());

                //debugging shows that we DO get the name in getName1()!!!
                String info = sharedPreferenceHelper.getName1();
               Toast tost= Toast.makeText(getApplicationContext(), info, Toast.LENGTH_LONG);
                tost.show();
            }
        };
        button_save.setOnClickListener(saving);
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
