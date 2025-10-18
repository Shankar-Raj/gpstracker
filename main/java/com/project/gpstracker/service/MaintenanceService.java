package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Maintenance;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MaintenanceService {

    public List<Maintenance> getAllMaintenances () {
        String endpoint = "/maintenance";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Maintenance[] MaintenanceArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Maintenance[].class);

        if (MaintenanceArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(MaintenanceArray);

    }

    public Maintenance getMaintenanceById(Long id) {
        String endpoint = "/maintenance/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Maintenance Maintenance = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Maintenance.class);

        if (Maintenance == null)
            return null; // Pass null up so controller can detect session expiry

        return Maintenance;

    }

    public Maintenance getMaintenances (boolean all, int userId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/maintenance" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Maintenance Maintenance = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Maintenance.class);

        if (Maintenance == null)
            return null; // Pass null up so controller can detect session expiry

        return Maintenance;

    }


}
