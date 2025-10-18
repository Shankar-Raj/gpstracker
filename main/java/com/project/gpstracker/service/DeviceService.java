package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Device;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DeviceService {

    public List<Device> getAllDevices() {
        String endpoint = "/devices";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Device[] DeviceArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Device[].class);

        if (DeviceArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(DeviceArray);
    }

    public Device getDeviceById(long id) {
        String endpoint = "/devices/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Device Device = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Device.class);

        if (Device == null)
            return null; // Pass null up so controller can detect session expiry

        return Device;
    }


    public Device getDevice(boolean all, int userId, int Id, int uniqueId) {
        String endpoint = "/devices" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + Id+
                "&groupId=" + uniqueId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Device Device = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Device.class);

        if (Device == null)
            return null; // Pass null up so controller can detect session expiry

        return Device;
    }
}
