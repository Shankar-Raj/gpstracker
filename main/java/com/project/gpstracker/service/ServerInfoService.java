package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.ServerInfo;
import com.project.gpstracker.model.ServerInfo;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class ServerInfoService {

    public ServerInfo getServerDetails () {
        String endpoint = "/server";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        ServerInfo ServerInfo = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, ServerInfo.class);

        if (ServerInfo == null)
            return null; // Pass null up so controller can detect session expiry

        return ServerInfo;

    }

}
