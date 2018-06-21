package com.example.shubhangsinghal.volleyexample2;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

class users {

    @SerializedName("id")
    String ID;

    String name;
    String email;
    String gender;
    Contact contact;

    public users(String ID, String name, String email, String gender, Contact contact) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.contact = contact;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Contact getContact() {
        return contact;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
