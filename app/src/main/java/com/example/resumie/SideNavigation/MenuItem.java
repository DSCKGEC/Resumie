package com.example.resumie.SideNavigation;

public class MenuItem {

    private int icon,code;
    private boolean selected;

    public MenuItem(int icon,int code) {
        this.icon=icon;
        this.code=code;

    }

    public MenuItem(int icon, int code, boolean selected) {
        this.icon = icon;
        this.code = code;
        this.selected = selected;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


}
