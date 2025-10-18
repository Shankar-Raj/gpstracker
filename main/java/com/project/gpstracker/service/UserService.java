package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.User;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        String endpoint = "/users";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        User[] UserArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, User[].class);

        if (UserArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(UserArray);
    }

    public User getUser(long id) {
        String endpoint = "/users/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        User user = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, User.class);

        if (user == null)
            return null; // Pass null up so controller can detect session expiry

        return user;
    }
}
