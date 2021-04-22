package com.example.resumie.SideNavigation;

import com.example.resumie.R;

import java.util.ArrayList;
import java.util.List;

public class MenuUtil {
    public static final int HOME_FRAGMENT=0;
    public static final int CV_FRAGMENT=1;
    public static final int PORTFOLIO_FRAGMENT=2;
    public static final int TEAM_FRAGMENT=3;
    public static final int PDF_FRAGMENT=4;

    public static List<MenuItem> getMenuList() {

        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem(R.drawable.ic_baseline_home_24,HOME_FRAGMENT,true));
        list.add(new MenuItem(R.drawable.ic_baseline_account_box_24,CV_FRAGMENT,false));
        list.add(new MenuItem(R.drawable.ic_baseline_work_24,PORTFOLIO_FRAGMENT,false));
        list.add(new MenuItem(R.drawable.ic_baseline_group_24,TEAM_FRAGMENT,false));
        list.add(new MenuItem(R.drawable.ic_baseline_book_24,PDF_FRAGMENT,false));
        return list;
    }
}
