package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Group;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class GroupService {

    public List<Group> getAllGroups () {
        String endpoint = "/groups";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Group[] GroupArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Group[].class);

        if (GroupArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(GroupArray);

    }

    public Group getGroupById(Long id) {
        String endpoint = "/groups/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Group Group = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Group.class);

        if (Group == null)
            return null; // Pass null up so controller can detect session expiry

        return Group;

    }

    public Group getGroups (boolean all, int userId) {
        String endpoint = "/groups" +
                "?all=" + all +
                "&userId=" +userId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Group Group = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Group.class);

        if (Group == null)
            return null; // Pass null up so controller can detect session expiry

        return Group;

    }


}
