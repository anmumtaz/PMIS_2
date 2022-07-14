package com.example.pmis_2;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String name;
    private String email;
    private String password;
    private String usertype;
    private String uid;



    public User(){
    }

    public User (String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String usertype, String uid) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
