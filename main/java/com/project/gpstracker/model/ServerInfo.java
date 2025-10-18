package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerInfo {

    private int id;
    private Map<String, Object> attributes;
    private boolean registration;
    private boolean readonly;
    private boolean deviceReadonly;
    private String map;
    private String bingKey;
    private String mapUrl;
    private String overlayUrl;
    private double latitude;
    private double longitude;
    private int zoom;
    private boolean forceSettings;
    private String coordinateFormat;
    private boolean limitCommands;
    private boolean disableReports;
    private boolean fixedEmail;
    private String poiLayer;
    private String announcement;
    private boolean emailEnabled;
    private boolean geocoderEnabled;
    private boolean textEnabled;
    private List<Long> storageSpace;
    private boolean newServer;
    private boolean openIdEnabled;
    private boolean openIdForce;
    private String version;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public boolean isRegistration() { return registration; }
    public void setRegistration(boolean registration) { this.registration = registration; }

    public boolean isReadonly() { return readonly; }
    public void setReadonly(boolean readonly) { this.readonly = readonly; }

    public boolean isDeviceReadonly() { return deviceReadonly; }
    public void setDeviceReadonly(boolean deviceReadonly) { this.deviceReadonly = deviceReadonly; }

    public String getMap() { return map; }
    public void setMap(String map) { this.map = map; }

    public String getBingKey() { return bingKey; }
    public void setBingKey(String bingKey) { this.bingKey = bingKey; }

    public String getMapUrl() { return mapUrl; }
    public void setMapUrl(String mapUrl) { this.mapUrl = mapUrl; }

    public String getOverlayUrl() { return overlayUrl; }
    public void setOverlayUrl(String overlayUrl) { this.overlayUrl = overlayUrl; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getZoom() { return zoom; }
    public void setZoom(int zoom) { this.zoom = zoom; }

    public boolean isForceSettings() { return forceSettings; }
    public void setForceSettings(boolean forceSettings) { this.forceSettings = forceSettings; }

    public String getCoordinateFormat() { return coordinateFormat; }
    public void setCoordinateFormat(String coordinateFormat) { this.coordinateFormat = coordinateFormat; }

    public boolean isLimitCommands() { return limitCommands; }
    public void setLimitCommands(boolean limitCommands) { this.limitCommands = limitCommands; }

    public boolean isDisableReports() { return disableReports; }
    public void setDisableReports(boolean disableReports) { this.disableReports = disableReports; }

    public boolean isFixedEmail() { return fixedEmail; }
    public void setFixedEmail(boolean fixedEmail) { this.fixedEmail = fixedEmail; }

    public String getPoiLayer() { return poiLayer; }
    public void setPoiLayer(String poiLayer) { this.poiLayer = poiLayer; }

    public String getAnnouncement() { return announcement; }
    public void setAnnouncement(String announcement) { this.announcement = announcement; }

    public boolean isEmailEnabled() { return emailEnabled; }
    public void setEmailEnabled(boolean emailEnabled) { this.emailEnabled = emailEnabled; }

    public boolean isGeocoderEnabled() { return geocoderEnabled; }
    public void setGeocoderEnabled(boolean geocoderEnabled) { this.geocoderEnabled = geocoderEnabled; }

    public boolean isTextEnabled() { return textEnabled; }
    public void setTextEnabled(boolean textEnabled) { this.textEnabled = textEnabled; }

    public List<Long> getStorageSpace() { return storageSpace; }
    public void setStorageSpace(List<Long> storageSpace) { this.storageSpace = storageSpace; }

    public boolean isNewServer() { return newServer; }
    public void setNewServer(boolean newServer) { this.newServer = newServer; }

    public boolean isOpenIdEnabled() { return openIdEnabled; }
    public void setOpenIdEnabled(boolean openIdEnabled) { this.openIdEnabled = openIdEnabled; }

    public boolean isOpenIdForce() { return openIdForce; }
    public void setOpenIdForce(boolean openIdForce) { this.openIdForce = openIdForce; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "id=" + id +
                ", registration=" + registration +
                ", readonly=" + readonly +
                ", deviceReadonly=" + deviceReadonly +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", zoom=" + zoom +
                ", geocoderEnabled=" + geocoderEnabled +
                ", version='" + version + '\'' +
                '}';
    }
}
