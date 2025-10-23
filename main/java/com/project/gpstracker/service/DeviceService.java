package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Device;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    public Device[] getAllDevices() {
        String endpoint = "/devices";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Device[].class);
    }

    public Device getDeviceById(long id) {
        String endpoint = "/devices/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Device.class);
    }

    public Device[] getDevice(boolean all, int userId, int Id, int uniqueId) {
        String endpoint = "/devices" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + Id+
                "&uniqueId=" + uniqueId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Device[].class);
    }
}
