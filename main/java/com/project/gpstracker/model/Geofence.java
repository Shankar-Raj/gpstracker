package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geofence {

    private int id;
    private Map<String, Object> attributes;
    private int calendarId;
    private String name;
    private String description;
    private String area;

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

    public int getCalendarId() {
        return calendarId;
    }
    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Geofence{" +
                "id=" + id +
                ", attributes=" + attributes +
                ", calendarId=" + calendarId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
