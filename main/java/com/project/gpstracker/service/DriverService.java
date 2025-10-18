package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Driver;
import com.project.gpstracker.model.Driver;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DriverService {

    public List<Driver> getDrivers () {
        String endpoint = "/drivers";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Driver[] DriverArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Driver[].class);

        if (DriverArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(DriverArray);

    }

    public Driver getDriverById(Long id) {
        String endpoint = "/drivers/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Driver Driver = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Driver.class);

        if (Driver == null)
            return null; // Pass null up so controller can detect session expiry

        return Driver;

    }

    public Driver getDriver (boolean all, int userId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/drivers" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Driver Driver = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Driver.class);

        if (Driver == null)
            return null; // Pass null up so controller can detect session expiry

        return Driver;

    }

}
