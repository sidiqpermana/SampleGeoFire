package com.sidiq.samplegeofire;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sidiq on 26/01/2016.
 */
public class SampleGeoFirePrefs {
    private String KEY_USERNAME = "username";
    private String PREFS_NAME = "samplegeofireprefs";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Activity activity;

    public SampleGeoFirePrefs(Activity activity){
        this.activity = activity;
        sharedPreferences = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUsername(String username){
        editor.putString(KEY_USERNAME, username);
        editor.commit();
    }

    public String getUsername(){
        return sharedPreferences.getString(KEY_USERNAME, "");
    }
}
