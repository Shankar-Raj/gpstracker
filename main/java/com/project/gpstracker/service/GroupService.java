package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Group;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    public Group[] getAllGroups () {
        String endpoint = "/groups?all=true";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Group[].class);

    }

    public Group getGroupById(int Id) {
        String endpoint = "/groups/"+Id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Group.class);
    }

    public Group[] getGroups (boolean all, int userId) {
        String endpoint = "/groups" +
                "?all=" +all+
                "&userId=" +userId;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Group[].class);

    }

}
