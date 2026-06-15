package com.springboot.aiagentsbackend.model;

public class Agent {

    private Long id;
    private String name;
    private String role;
    private String description;

    public Agent() {
    }

    public Agent(Long id, String name, String role, String description) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}