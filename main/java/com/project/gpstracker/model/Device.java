package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {
    private int id;
    private Map<String, Object> attributes;
    private int groupId;
    private int calendarId;
    private String name;
    private String uniqueId;
    private String status;

    @JsonProperty("lastUpdate")
    private OffsetDateTime lastUpdate;

    private int positionId;
    private String phone;
    private String model;
    private String contact;
    private String category;
    private boolean disabled;
    private String expirationTime;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public int getGroupId() { return groupId; }
    public void setGroupId(int groupId) { this.groupId = groupId; }

    public int getCalendarId() { return calendarId; }
    public void setCalendarId(int calendarId) { this.calendarId = calendarId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUniqueId() { return uniqueId; }
    public void setUniqueId(String uniqueId) { this.uniqueId = uniqueId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public OffsetDateTime getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(OffsetDateTime lastUpdate) { this.lastUpdate = lastUpdate; }

    public int getPositionId() { return positionId; }
    public void setPositionId(int positionId) { this.positionId = positionId; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isDisabled() { return disabled; }
    public void setDisabled(boolean disabled) { this.disabled = disabled; }

    public String getExpirationTime() { return expirationTime; }
    public void setExpirationTime(String expirationTime) { this.expirationTime = expirationTime; }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", status='" + status + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
