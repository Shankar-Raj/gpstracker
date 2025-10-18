package com.project.gpstracker.model.reports;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TripReport {

    @JsonProperty("deviceId")
    private int deviceId;

    @JsonProperty("deviceName")
    private String deviceName;

    @JsonProperty("distance")
    private double distance;

    @JsonProperty("averageSpeed")
    private double averageSpeed;

    @JsonProperty("maxSpeed")
    private double maxSpeed;

    @JsonProperty("spentFuel")
    private double spentFuel;

    @JsonProperty("startOdometer")
    private double startOdometer;

    @JsonProperty("endOdometer")
    private double endOdometer;

    @JsonProperty("startTime")
    private OffsetDateTime startTime;

    @JsonProperty("endTime")
    private OffsetDateTime endTime;

    @JsonProperty("startPositionId")
    private int startPositionId;

    @JsonProperty("endPositionId")
    private int endPositionId;

    @JsonProperty("startLat")
    private double startLat;

    @JsonProperty("startLon")
    private double startLon;

    @JsonProperty("endLat")
    private double endLat;

    @JsonProperty("endLon")
    private double endLon;

    @JsonProperty("startAddress")
    private String startAddress;

    @JsonProperty("endAddress")
    private String endAddress;

    @JsonProperty("duration")
    private long duration;

    @JsonProperty("driverUniqueId")
    private String driverUniqueId;

    @JsonProperty("driverName")
    private String driverName;

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

    public int getStartPositionId() { return startPositionId; }
    public void setStartPositionId(int startPositionId) { this.startPositionId = startPositionId; }

    public int getEndPositionId() { return endPositionId; }
    public void setEndPositionId(int endPositionId) { this.endPositionId = endPositionId; }

    public double getStartLat() { return startLat; }
    public void setStartLat(double startLat) { this.startLat = startLat; }

    public double getStartLon() { return startLon; }
    public void setStartLon(double startLon) { this.startLon = startLon; }

    public double getEndLat() { return endLat; }
    public void setEndLat(double endLat) { this.endLat = endLat; }

    public double getEndLon() { return endLon; }
    public void setEndLon(double endLon) { this.endLon = endLon; }

    public String getStartAddress() { return startAddress; }
    public void setStartAddress(String startAddress) { this.startAddress = startAddress; }

    public String getEndAddress() { return endAddress; }
    public void setEndAddress(String endAddress) { this.endAddress = endAddress; }

    public long getDuration() { return duration; }
    public void setDuration(long duration) { this.duration = duration; }

    public String getDriverUniqueId() { return driverUniqueId; }
    public void setDriverUniqueId(String driverUniqueId) { this.driverUniqueId = driverUniqueId; }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }

    @Override
    public String toString() {
        return "TripReportService{" +
                "deviceName='" + deviceName + '\'' +
                ", distance=" + distance +
                ", averageSpeed=" + averageSpeed +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startAddress='" + startAddress + '\'' +
                ", endAddress='" + endAddress + '\'' +
                '}';
    }
}
