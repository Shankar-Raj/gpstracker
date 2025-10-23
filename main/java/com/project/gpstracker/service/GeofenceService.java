package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Geofence;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GeofenceService {

    public Geofence[] getAllGeofence () {
        String endpoint = "/geofences";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Geofence[].class);
    }

    public Geofence getGeofenceById(Long id) {
        String endpoint = "/geofences/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Geofence Geofence = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Geofence.class);

        if (Geofence == null)
            return null; // Pass null up so controller can detect session expiry

        return Geofence;
    }

    public Geofence[] getGeofence (boolean all, int userId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/geofences" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Geofence[].class);
    }

}
