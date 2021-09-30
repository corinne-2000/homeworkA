package com.example.homeworka;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class SharedPreferenceHelper {
private SharedPreferences sharedPreferences;
protected int increment  =0;
protected String pfname1 = "";
protected String pfname2 = "";
    protected String pfname3 = "";
protected String key = "";
protected String name = "";
Map <String, String> map =  new HashMap<>();


    public SharedPreferenceHelper (Context context){
        this.sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE );
    }
    public void saveProfileName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName",name );
        editor.commit();
    }
    public String getProfileName(String key)
    {
        return sharedPreferences.getString(key, " ");
        //ask anonna
        //return map.get(key);

    }

    //the count for particular ones
    public void setIncreaseCountEachEvent(Integer number) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        number++;
        editor.putInt("increaseEach",number );
        editor.commit();
    }

    public Integer getCountofEachEvent(Integer number) {
        return sharedPreferences.getInt("counter", number);
    }



//each time, this number increases.
    public void setIncreaseCountForAllEvents() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        increment++;
        editor.putInt("Increment",increment );
        editor.commit();
    }

    public Integer getCountofAllEvents() {
        return sharedPreferences.getInt("counter", increment);
    }

    public void setProfileName(String key, String name) {

        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(key,name);
        map.put(key, name);

        editor.commit();
    }

    public void setMaxCounter(Integer count_max) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("profileName",count_max );
        editor.commit();
    }

    public void setProfileName1(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName1",name );
        editor.commit();
    }

    public void setProfileName2(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName2",name );
        editor.commit();
    }

    public void setProfileName3(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName3",name );
        editor.commit();
    }

    public String getName1() {
        return sharedPreferences.getString("profileName1", "");
    }

    public String getName2() {
        return sharedPreferences.getString("profileName2", "");

    }
    public String getName3() {
        return sharedPreferences.getString("profileName3", "");

    }
}
