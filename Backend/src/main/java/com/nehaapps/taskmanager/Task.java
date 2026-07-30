package com.nehaapps.taskmanager;

import org.springframework.data.annotation.Id;

public class Task {
    @Id
    private String id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    private String title;
    private boolean completed;
    
    
    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }
     
    public Task() {
    }
}
