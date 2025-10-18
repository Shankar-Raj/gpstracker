package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Maintenance {

    private int id;
    private Map<String, Object> attributes;
    private String name;
    private String type;
    private double start;
    private double period;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getStart() { return start; }
    public void setStart(double start) { this.start = start; }

    public double getPeriod() { return period; }
    public void setPeriod(double period) { this.period = period; }

    @Override
    public String toString() {
        return "Maintenance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", start=" + start +
                ", period=" + period +
                '}';
    }
}
