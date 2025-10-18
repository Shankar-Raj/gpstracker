package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedAttribute { //like rules

    private int id;
    private String description;
    private String attribute;
    private String expression;
    private String type;
    private int priority;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAttribute() { return attribute; }
    public void setAttribute(String attribute) { this.attribute = attribute; }

    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", attribute='" + attribute + '\'' +
                ", expression='" + expression + '\'' +
                ", type='" + type + '\'' +
                ", priority=" + priority +
                '}';
    }
}
