package com.example.homeworka;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedPreferenceHelper {
private SharedPreferences sharedPreferences;
protected int increment  =0;
protected int incrementA  =0;
protected int incrementB  =0;
protected int incrementC  =0;
protected List <String> array_of_button = new ArrayList<>();
private Context context;

    public SharedPreferenceHelper (Context context){
        this.context = context;
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
        return sharedPreferences.getString(key, "");


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

//    public void setProfileName(String key, String name) {
//        SharedPreferences.Editor editor = this.sharedPreferences.edit();
//        editor.putString(key,name);
//        editor.commit();
//    }

    public void setMaxCounter(String count_max) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterMax",count_max );
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
        return sharedPreferences.getString("profileName1", null);
    }

    public String getName2() {
        return sharedPreferences.getString("profileName2", null);

    }
    public String getName3() {
        return sharedPreferences.getString("profileName3", null);

    }

    public String getMaxCount() {
        return sharedPreferences.getString("counterMax", null);
    }

    public void setIncreaseA() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        incrementA++;
        String incrementStringA = Integer.toString(incrementA);
        editor.putString("IncrementA",incrementStringA );
        editor.commit();
    }

    public void setIncreaseB() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        incrementB++;
        String incrementStringB = Integer.toString(incrementB);
        editor.putString("IncrementB",incrementStringB );
        editor.commit();
    }

    public void setIncreaseC() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        incrementC++;
        String incrementStringC = Integer.toString(incrementC);
        editor.putString("IncrementC",incrementStringC );
        editor.commit();
    }
    public String getCountA() {

        return sharedPreferences.getString("IncrementA", ""); }

    public String getCountB() {
        return sharedPreferences.getString("counter2", "");
    }
    public String getCountC() {
        return sharedPreferences.getString("counter3", "");
    }

    public void goToAddName(Button button) {


        String name = button.getText().toString();
        array_of_button.add(name);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(array_of_button);
        editor.putStringSet("ArrayOfButtons", set);
        editor.commit();

    }

    public Set<String> getListNames(){
        return sharedPreferences.getStringSet("ArrayOfButtons", null);
    }

}
