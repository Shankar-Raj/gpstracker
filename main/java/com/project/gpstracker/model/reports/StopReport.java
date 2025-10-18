package com.project.gpstracker.model.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopReport {

    private int deviceId;
    private String deviceName;
    private double distance;
    private double averageSpeed;
    private double maxSpeed;
    private double spentFuel;
    private double startOdometer;
    private double endOdometer;

    @JsonProperty("startTime")
    private OffsetDateTime startTime;

    @JsonProperty("endTime")
    private OffsetDateTime endTime;

    private int positionId;
    private double latitude;
    private double longitude;
    private String address;
    private long duration;
    private int engineHours;

    // Getters and Setters
    public int getDeviceId() { return deviceId; }
    public void setDeviceId(int deviceId) { this.deviceId = deviceId; }

    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getAverageSpeed() { return averageSpeed; }
    public void setAverageSpeed(double averageSpeed) { this.averageSpeed = averageSpeed; }

    public double getMaxSpeed() { return maxSpeed; }
    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }

    public double getSpentFuel() { return spentFuel; }
    public void setSpentFuel(double spentFuel) { this.spentFuel = spentFuel; }

    public double getStartOdometer() { return startOdometer; }
    public void setStartOdometer(double startOdometer) { this.startOdometer = startOdometer; }

    public double getEndOdometer() { return endOdometer; }
    public void setEndOdometer(double endOdometer) { this.endOdometer = endOdometer; }

    public OffsetDateTime getStartTime() { return startTime; }
    public void setStartTime(OffsetDateTime startTime) { this.startTime = startTime; }

    public OffsetDateTime getEndTime() { return endTime; }
    public void setEndTime(OffsetDateTime endTime) { this.endTime = endTime; }

    public int getPositionId() { return positionId; }
    public void setPositionId(int positionId) { this.positionId = positionId; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public long getDuration() { return duration; }
    public void setDuration(long duration) { this.duration = duration; }

    public int getEngineHours() { return engineHours; }
    public void setEngineHours(int engineHours) { this.engineHours = engineHours; }

    @Override
    public String toString() {
        return "Stop{" +
                "deviceId=" + deviceId +
                ", deviceName='" + deviceName + '\'' +
                ", distance=" + distance +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", positionId=" + positionId +
                '}';
    }
}
