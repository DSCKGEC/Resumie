package com.example.resumie.SharedPrefManager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.resumie.CV.CVitem;
import com.example.resumie.R;
import com.example.resumie.UserModel.UserModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

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
        else if(num == 6) {
            editor.putString("DISPLAY_IMAGE", str);
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
                sharedPreferences.getString("SKILL", null),
                sharedPreferences.getString("DISPLAY_IMAGE", null));
    }


    public void setUserIntro(String str){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("BRIEF_INTRO",str);
        editor.apply();
    }

    public String getUserIntro()
    {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("BRIEF_INTRO",null);
    }


    public void setUserPortfolio(ArrayList <CVitem> arrayList)
    {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString("PORTFOLIO_LIST",json);
        editor.apply();
    }

    public ArrayList<CVitem> getUserPortFolio()
    {
        Gson gson = new Gson();
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("PORTFOLIO_LIST",null);
        Type type = new TypeToken<ArrayList<CVitem>>() {}.getType();

        return gson.fromJson(json,type);
    }

}
