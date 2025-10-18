package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Geofence;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GeofenceService {

    public String getAllGeofence () {
        String endpoint = "/geofences";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Geofence[] GeofenceArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Geofence[].class);

        if (GeofenceArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.toString(GeofenceArray);
    }

    public String getGeofenceById(Long id) {
        String endpoint = "/geofences/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Geofence Geofence = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Geofence.class);

        if (Geofence == null)
            return null; // Pass null up so controller can detect session expiry

        return Geofence.toString();
    }

    public String getGeofence (boolean all, int userId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/geofences" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Geofence Geofence = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Geofence.class);

        if (Geofence == null)
            return null; // Pass null up so controller can detect session expiry

        return Geofence.toString();
    }

}
