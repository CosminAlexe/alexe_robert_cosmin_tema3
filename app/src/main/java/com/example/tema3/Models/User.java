package com.example.tema3.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    private int id;

    private String name;

    private String username;

    private String email;

    public User(int id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject userJSON = new JSONObject();
        userJSON.put("id", id);
        userJSON.put("name", name);
        userJSON.put("username", username);
        userJSON.put("email", email);
        return userJSON;
    }

    public User fromJSON(JSONObject userJSON) throws JSONException{
        int id = userJSON.getInt("id");
        String name = userJSON.getString("name");
        String username = userJSON.getString("username");
        String email = userJSON.getString("email");
        return new User(id, name, username, email);
    }
}
