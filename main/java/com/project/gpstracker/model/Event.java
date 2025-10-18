package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    private int id;
    private Map<String, Object> attributes;
    private int deviceId;
    private String type;

    @JsonProperty("eventTime")
    private OffsetDateTime eventTime;

    private int positionId;
    private int geofenceId;
    private int maintenanceId;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public int getDeviceId() { return deviceId; }
    public void setDeviceId(int deviceId) { this.deviceId = deviceId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public OffsetDateTime getEventTime() { return eventTime; }
    public void setEventTime(OffsetDateTime eventTime) { this.eventTime = eventTime; }

    public int getPositionId() { return positionId; }
    public void setPositionId(int positionId) { this.positionId = positionId; }

    public int getGeofenceId() { return geofenceId; }
    public void setGeofenceId(int geofenceId) { this.geofenceId = geofenceId; }

    public int getMaintenanceId() { return maintenanceId; }
    public void setMaintenanceId(int maintenanceId) { this.maintenanceId = maintenanceId; }

    @Override
    public String toString() {
        return "EventReport{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", deviceId=" + deviceId +
                ", eventTime=" + eventTime +
                ", positionId=" + positionId +
                ", geofenceId=" + geofenceId +
                ", maintenanceId=" + maintenanceId +
                '}';
    }
}
