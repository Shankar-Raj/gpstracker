package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

    private int id;
    private Map<String, Object> attributes;
    private int groupId;
    private String name;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public int getGroupId() { return groupId; }
    public void setGroupId(int groupId) { this.groupId = groupId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", name='" + name + '\'' +
                '}';
    }
}
