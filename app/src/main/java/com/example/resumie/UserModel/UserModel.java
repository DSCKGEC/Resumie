package com.example.resumie.UserModel;

public class UserModel {

    private String name;
    private String designation;
    private String self;
    private String edu;
    private String skill;
    private String profileImage;

    public UserModel(String name, String designation, String self, String edu, String skill, String profileImage) {
        this.name = name;
        this.designation = designation;
        this.self = self;
        this.edu = edu;
        this.skill = skill;
        this.profileImage = profileImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
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
