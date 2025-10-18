package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.ComputedAttribute;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ComputedAttributeService {

    public List<ComputedAttribute> getAllAttributes () {
        String endpoint = "/attributes/computed";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        ComputedAttribute[] ComputedAttributeArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ComputedAttribute[].class);

        if (ComputedAttributeArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(ComputedAttributeArray);
    }

    public ComputedAttribute getAttributeById(Long id) {
        String endpoint = "/attributes/computed/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        ComputedAttribute ComputedAttribute = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ComputedAttribute.class);

        if (ComputedAttribute == null)
            return null; // Pass null up so controller can detect session expiry

        return ComputedAttribute;
    }

    public ComputedAttribute getAttributes (boolean all, int ComputedAttributeId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/attributes/computed" +
                "?all=" + all +
                "&ComputedAttributeId=" +ComputedAttributeId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        ComputedAttribute ComputedAttribute = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ComputedAttribute.class);

        if (ComputedAttribute == null)
            return null; // Pass null up so controller can detect session expiry

        return ComputedAttribute;
    }


}
