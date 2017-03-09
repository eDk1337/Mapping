package com.example.a2ramae45.mapping;
import android.preference.PreferenceActivity;
import android.os.Bundle;

public class MyPrefActivity extends PreferenceActivity{

    public void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }




}
