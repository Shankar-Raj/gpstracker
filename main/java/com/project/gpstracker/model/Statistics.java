package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {

    private int id;
    private Map<String, Object> attributes;
    private OffsetDateTime captureTime;
    private int activeUsers;
    private int activeDevices;
    private int requests;
    private int messagesReceived;
    private int messagesStored;
    private int mailSent;
    private int smsSent;
    private int geocoderRequests;
    private int geolocationRequests;
    private String protocols;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public OffsetDateTime getCaptureTime() { return captureTime; }
    public void setCaptureTime(OffsetDateTime captureTime) { this.captureTime = captureTime; }

    public int getActiveUsers() { return activeUsers; }
    public void setActiveUsers(int activeUsers) { this.activeUsers = activeUsers; }

    public int getActiveDevices() { return activeDevices; }
    public void setActiveDevices(int activeDevices) { this.activeDevices = activeDevices; }

    public int getRequests() { return requests; }
    public void setRequests(int requests) { this.requests = requests; }

    public int getMessagesReceived() { return messagesReceived; }
    public void setMessagesReceived(int messagesReceived) { this.messagesReceived = messagesReceived; }

    public int getMessagesStored() { return messagesStored; }
    public void setMessagesStored(int messagesStored) { this.messagesStored = messagesStored; }

    public int getMailSent() { return mailSent; }
    public void setMailSent(int mailSent) { this.mailSent = mailSent; }

    public int getSmsSent() { return smsSent; }
    public void setSmsSent(int smsSent) { this.smsSent = smsSent; }

    public int getGeocoderRequests() { return geocoderRequests; }
    public void setGeocoderRequests(int geocoderRequests) { this.geocoderRequests = geocoderRequests; }

    public int getGeolocationRequests() { return geolocationRequests; }
    public void setGeolocationRequests(int geolocationRequests) { this.geolocationRequests = geolocationRequests; }

    public String getProtocols() { return protocols; }
    public void setProtocols(String protocols) { this.protocols = protocols; }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", captureTime=" + captureTime +
                ", activeUsers=" + activeUsers +
                ", activeDevices=" + activeDevices +
                ", requests=" + requests +
                ", messagesReceived=" + messagesReceived +
                ", mailSent=" + mailSent +
                ", geocoderRequests=" + geocoderRequests +
                ", protocols='" + protocols + '\'' +
                '}';
    }
}
