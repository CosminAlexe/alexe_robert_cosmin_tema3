package com.example.tema3.Models;

import org.json.JSONException;
import org.json.JSONObject;

public class ToDo {

    private int id;

    private int userId;

    private String title;

    private Boolean completed;

    public ToDo() {

    }

    public ToDo(int id, int userId, String title, Boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject ToDoJSON = new JSONObject();
        ToDoJSON.put("id", id);
        ToDoJSON.put("userId", userId);
        ToDoJSON.put("title", title);
        ToDoJSON.put("completed", completed);
        return ToDoJSON;
    }

    public ToDo fromJSON(JSONObject itemJSON) throws JSONException{
        int id = itemJSON.getInt("id");
        int userId = itemJSON.getInt("userId");
        String title = itemJSON.getString("title");
        Boolean completed = itemJSON.getBoolean("completed");
        return new ToDo(id, userId, title, completed);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

}
