package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.ServerInfo;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class ServerInfoService {

    public ServerInfo getServerDetails () {
        String endpoint = "/server";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ServerInfo.class);

    }

}
