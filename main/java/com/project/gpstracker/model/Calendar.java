package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Calendar {

    private int id;
    private Map<String, Object> attributes;
    private String name;
    private String data;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
