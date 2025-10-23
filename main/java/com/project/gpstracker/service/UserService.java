package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.User;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User[] getUsers() {
        String endpoint = "/users";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, User[].class);
    }

    public User getUser(long id) {
        String endpoint = "/users/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, User.class);
    }
}
