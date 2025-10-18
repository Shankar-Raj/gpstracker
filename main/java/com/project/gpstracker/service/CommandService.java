package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Command;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CommandService {

    public List<Command> getAllCommands () {
        String endpoint = "/commands";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Command[] CommandArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Command[].class);

        if (CommandArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(CommandArray);

    }

    public Command getCommandById(int id) {
        String endpoint = "/commands/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Command Command = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Command.class);

        if (Command == null)
            return null; // Pass null up so controller can detect session expiry

        return Command;

    }

    public Command getCommands (boolean all, int userId, int CommandId, int groupId, boolean refresh) {
        String endpoint = "/commands" +
                "?all=" + all +
                "&userId=" +userId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Command Command = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Command.class);

        if (Command == null)
            return null; // Pass null up so controller can detect session expiry

        return Command;

    }


}
