package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {

    private int id;
    private Map<String, Object> attributes;
    private String description;
    private int calendarId;
    private boolean always;
    private String type;
    private int commandId;
    private String notificators;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCalendarId() { return calendarId; }
    public void setCalendarId(int calendarId) { this.calendarId = calendarId; }

    public boolean isAlways() { return always; }
    public void setAlways(boolean always) { this.always = always; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getCommandId() { return commandId; }
    public void setCommandId(int commandId) { this.commandId = commandId; }

    public String getNotificators() { return notificators; }
    public void setNotificators(String notificators) { this.notificators = notificators; }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", calendarId=" + calendarId +
                ", always=" + always +
                ", type='" + type + '\'' +
                ", commandId=" + commandId +
                ", notificators='" + notificators + '\'' +
                '}';
    }
}
