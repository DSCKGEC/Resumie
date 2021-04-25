package com.example.resumie.UserModel;

public class UserModel {

    private String name;
    private String designation;
    private String self;
    private String edu;
    private String skill;

    public UserModel(String name, String designation, String self, String edu, String skill) {
        this.name = name;
        this.designation = designation;
        this.self = self;
        this.edu = edu;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getSelf() {
        return self;
    }

    public String getEdu() {
        return edu;
    }

    public String getSkill() {
        return skill;
    }
}
