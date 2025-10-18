package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Command {

    private int id;
    private Map<String, Object> attributes;
    private int deviceId;
    private String type;
    private boolean textChannel;
    private String description;

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

    public int getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public boolean isTextChannel() {
        return textChannel;
    }
    public void setTextChannel(boolean textChannel) {
        this.textChannel = textChannel;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", attributes=" + attributes +
                ", deviceId=" + deviceId +
                ", type='" + type + '\'' +
                ", textChannel=" + textChannel +
                ", description='" + description + '\'' +
                '}';
    }
}
