package com.project.gpstracker.model.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RouteReport {

    private long id;
    private Map<String, Object> attributes;
    private int deviceId;
    private String protocol;
    private String serverTime;
    private String deviceTime;
    private String fixTime;
    private boolean valid;
    private double latitude;
    private double longitude;
    private double altitude;
    private double speed;
    private double course;
    private String address;
    private double accuracy;
    private Object network;
    private List<Long> geofenceIds;

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public int getDeviceId() { return deviceId; }
    public void setDeviceId(int deviceId) { this.deviceId = deviceId; }

    public String getProtocol() { return protocol; }
    public void setProtocol(String protocol) { this.protocol = protocol; }

    public String getServerTime() { return serverTime; }
    public void setServerTime(String serverTime) { this.serverTime = serverTime; }

    public String getDeviceTime() { return deviceTime; }
    public void setDeviceTime(String deviceTime) { this.deviceTime = deviceTime; }

    public String getFixTime() { return fixTime; }
    public void setFixTime(String fixTime) { this.fixTime = fixTime; }

    public boolean isValid() { return valid; }
    public void setValid(boolean valid) { this.valid = valid; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getAltitude() { return altitude; }
    public void setAltitude(double altitude) { this.altitude = altitude; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public double getCourse() { return course; }
    public void setCourse(double course) { this.course = course; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getAccuracy() { return accuracy; }
    public void setAccuracy(double accuracy) { this.accuracy = accuracy; }

    public Object getNetwork() { return network; }
    public void setNetwork(Object network) { this.network = network; }

    public List<Long> getGeofenceIds() { return geofenceIds; }
    public void setGeofenceIds(List<Long> geofenceIds) { this.geofenceIds = geofenceIds; }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", speed=" + speed +
                ", course=" + course +
                ", valid=" + valid +
                '}';
    }
}
