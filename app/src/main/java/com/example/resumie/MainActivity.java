package com.example.resumie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resumie.CV.CVFragment;
import com.example.resumie.home.HomeFragment;
import com.example.resumie.team.TeamFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
//        setHomeFragment();
//        setCVFragment();
          setTeamFragment();
    }

    void setCVFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new CVFragment()).commit();
    }

    void setHomeFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
    }

    void setTeamFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new TeamFragment()).commit();
    }
}