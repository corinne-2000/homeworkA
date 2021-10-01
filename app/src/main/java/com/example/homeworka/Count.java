package com.example.homeworka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Count extends AppCompatActivity {



    protected TextView eventA, eventB, eventC, max_counts;
    protected Button button;
    public SharedPreferenceHelper sharedPreferenceHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        goToUISetup();
        sharedPreferenceHelper = new SharedPreferenceHelper(Count.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.count3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon_action:{
                Toast tost= Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_LONG);
                return true;
            }
            case R.id.home:{
                Toast tost= Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_LONG);
                goToMain();
                return true;
            }
            default:return super.onOptionsItemSelected(item);
        }
    }
    private void goToUISetup () {

        String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X", "Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X", "Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X", "Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X"};


        eventA = findViewById(R.id.eventA);
        eventB = findViewById(R.id.eventB);
        eventC = findViewById(R.id.eventC);
        max_counts = findViewById(R.id.max_counts);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain();
            }
        });

        SharedPreferences myPrefs = getApplicationContext().getSharedPreferences("ProfilePreference", MODE_PRIVATE);

        String eAName = myPrefs.getString("profileName1", "");
        String eBName = myPrefs.getString("profileName2", "");
        String eCName = myPrefs.getString("profileName3", "");


        String numA = myPrefs.getString("IncrementA", "");
        String numB = myPrefs.getString("IncrementB", "");
        String numC = myPrefs.getString("IncrementC", "");
        String maxCount = myPrefs.getString("counterMax", "");

        eventA.setText(eAName + " : " + numA);
        eventB.setText(eBName + " : " + numB);
        eventC.setText(eCName + " : " + numC);



        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        max_counts.setText(getString(R.string.total) + maxCount);
        setSupportActionBar(toolbar2);


        Set<String> trying = myPrefs.getStringSet("ArrayOfButtons", null);
        List<String> actual = new ArrayList<String>();


         actual.addAll(trying);


        //for (int i=0; i<actual.size(); i++){
        //  String[i] arr = actual.get(i);

        // }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
               R.layout.listview, actual);
        ListView listView = (ListView) findViewById(R.id.list_events);
        listView.setAdapter(adapter);

    }
    private void goToMain() {
        Intent intent = new Intent  (this, MainActivity.class);
        startActivity(intent);
    };
}

