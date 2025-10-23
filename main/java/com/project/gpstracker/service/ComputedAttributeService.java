package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.ComputedAttribute;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class ComputedAttributeService {

    public ComputedAttribute[] getAllAttributes () {
        String endpoint = "/attributes/computed";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ComputedAttribute[].class);
    }

    public ComputedAttribute getAttributeById(Long id) {
        String endpoint = "/attributes/computed/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ComputedAttribute.class);
    }

    public ComputedAttribute[] getAttributes (boolean all, int ComputedAttributeId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/attributes/computed" +
                "?all=" + all +
                "&ComputedAttributeId=" +ComputedAttributeId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ComputedAttribute[].class);
    }


}
