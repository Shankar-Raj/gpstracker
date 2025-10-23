package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Driver;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    public Driver[] getDrivers () {
        String endpoint = "/drivers";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Driver[].class);

    }

    public Driver getDriverById(Long id) {
        String endpoint = "/drivers/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Driver.class);

    }

    public Driver[] getDriver (boolean all, int userId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/drivers" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Driver[].class);

    }

}
