package com.example.resumie.SharedPrefManager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.resumie.UserModel.UserModel;

public class SharedPrefManager {
    private static String SHARED_PREF_NAME = "StateStore";
    private SharedPreferences sharedPreferences;
    private Context context;
    private SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        this.context = context;
    }

    public void setHomeData(String str, int num) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(num == 1) {
            editor.putString("NAME", str);
        }else if(num == 2) {
            editor.putString("DESIGNATION", str);
        }else if(num == 3) {
            editor.putString("SELF", str);
        }else if(num == 4) {
            editor.putString("EDU", str);
        }else if(num == 5) {
            editor.putString("SKILL", str);
        }
        editor.apply();
    }

    public UserModel getHomeData(){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new UserModel(
                sharedPreferences.getString("NAME", null),
                sharedPreferences.getString("DESIGNATION", null),
                sharedPreferences.getString("SELF", null),
                sharedPreferences.getString("EDU", null),
                sharedPreferences.getString("SKILL", null));
    }

}
