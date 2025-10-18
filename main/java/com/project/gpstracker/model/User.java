package com.project.gpstracker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private int id;
    private Map<String, Object> attributes;
    private String name;
    private String login;
    private String email;
    private String phone;
    private boolean readonly;
    private boolean administrator;
    private String map;
    private double latitude;
    private double longitude;
    private int zoom;
    private String coordinateFormat;
    private boolean disabled;
    private String expirationTime;
    private int deviceLimit;
    private int userLimit;
    private boolean deviceReadonly;
    private boolean limitCommands;
    private boolean disableReports;
    private boolean fixedEmail;
    private String poiLayer;
    private String totpKey;
    private boolean temporary;
    private String password;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Map<String, Object> getAttributes() { return attributes; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public boolean isReadonly() { return readonly; }
    public void setReadonly(boolean readonly) { this.readonly = readonly; }

    public boolean isAdministrator() { return administrator; }
    public void setAdministrator(boolean administrator) { this.administrator = administrator; }

    public String getMap() { return map; }
    public void setMap(String map) { this.map = map; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public int getZoom() { return zoom; }
    public void setZoom(int zoom) { this.zoom = zoom; }

    public String getCoordinateFormat() { return coordinateFormat; }
    public void setCoordinateFormat(String coordinateFormat) { this.coordinateFormat = coordinateFormat; }

    public boolean isDisabled() { return disabled; }
    public void setDisabled(boolean disabled) { this.disabled = disabled; }

    public String getExpirationTime() { return expirationTime; }
    public void setExpirationTime(String expirationTime) { this.expirationTime = expirationTime; }

    public int getDeviceLimit() { return deviceLimit; }
    public void setDeviceLimit(int deviceLimit) { this.deviceLimit = deviceLimit; }

    public int getUserLimit() { return userLimit; }
    public void setUserLimit(int userLimit) { this.userLimit = userLimit; }

    public boolean isDeviceReadonly() { return deviceReadonly; }
    public void setDeviceReadonly(boolean deviceReadonly) { this.deviceReadonly = deviceReadonly; }

    public boolean isLimitCommands() { return limitCommands; }
    public void setLimitCommands(boolean limitCommands) { this.limitCommands = limitCommands; }

    public boolean isDisableReports() { return disableReports; }
    public void setDisableReports(boolean disableReports) { this.disableReports = disableReports; }

    public boolean isFixedEmail() { return fixedEmail; }
    public void setFixedEmail(boolean fixedEmail) { this.fixedEmail = fixedEmail; }

    public String getPoiLayer() { return poiLayer; }
    public void setPoiLayer(String poiLayer) { this.poiLayer = poiLayer; }

    public String getTotpKey() { return totpKey; }
    public void setTotpKey(String totpKey) { this.totpKey = totpKey; }

    public boolean isTemporary() { return temporary; }
    public void setTemporary(boolean temporary) { this.temporary = temporary; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", administrator=" + administrator +
                ", readonly=" + readonly +
                '}';
    }
}
