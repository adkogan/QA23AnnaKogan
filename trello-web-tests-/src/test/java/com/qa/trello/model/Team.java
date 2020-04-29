package com.qa.trello.model;

public class Team {
    public String name;
    public String description;

    public Team withName(String name) {
        this.name = name;
        return this;
    }

    public Team withDescription(String description) {
        this.description = description;
        return this;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
