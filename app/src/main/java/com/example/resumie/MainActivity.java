package com.example.resumie;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resumie.CV.CVFragment;
import com.example.resumie.PDF.PDFFragment;
import com.example.resumie.SideNavigation.MenuAdapter;
import com.example.resumie.SideNavigation.MenuItem;
import com.example.resumie.SideNavigation.MenuUtil;
import com.example.resumie.home.HomeFragment;
import com.example.resumie.portfolio.PortfolioFragment;
import com.example.resumie.team.TeamFragment;
import com.example.resumie.SideNavigation.ClickedCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickedCallback {


    RecyclerView recyclerView;
    MenuAdapter menuAdapter;
    List<MenuItem> menu;
    int selectedMenuPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSideNavigation();

        setHomeFragment();
    }

    private void setSideNavigation() {
        recyclerView = findViewById(R.id.recyclerview_nav);
        menu= MenuUtil.getMenuList();
        menuAdapter=new MenuAdapter(menu,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(menuAdapter);

    }

    void setPortfolioFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PortfolioFragment()).commit();
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

    void setPDFFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PDFFragment()).commit();
    }

    @Override
    public void onSideMenuItemClick(int i) {

        switch (menu.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT : setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT : setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT: setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT: setPortfolioFragment();
                break;
            case MenuUtil.PDF_FRAGMENT: setPDFFragment();
                break;
            default: setHomeFragment();
        }

        menu.get(selectedMenuPosition).setSelected(false);
        menu.get(i).setSelected(true);
        selectedMenuPosition = i ;
        menuAdapter.notifyDataSetChanged();

    }
}