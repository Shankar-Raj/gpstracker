package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Command;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class CommandService {

    public Command[] getAllCommands () {
        String endpoint = "/commands";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Command[].class);

    }

    public Command getCommandById(int id) {
        String endpoint = "/commands/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Command.class);

    }

    public Command[] getCommands (boolean all, int userId, int CommandId, int groupId, boolean refresh) {
        String endpoint = "/commands" +
                "?all=" + all +
                "&userId=" +userId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        return RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Command[].class);

    }


}
