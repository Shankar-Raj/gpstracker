package com.project.gpstracker.service;

import com.project.gpstracker.handlers.RestHandler;
import com.project.gpstracker.model.Notification;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NotificationService {

    public List<Notification> getAllNotifications () {
        String endpoint = "/notifications";
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Notification[] NotificationArray = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Notification[].class);

        if (NotificationArray == null) {
            return null; // Pass null up so controller can detect session expiry
        }

        return Arrays.asList(NotificationArray);

    }

    public Notification getNotificationById(Long id) {
        String endpoint = "/notifications/"+id;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Notification Notification = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Notification.class);

        if (Notification == null)
            return null; // Pass null up so controller can detect session expiry

        return Notification;

    }

    public Notification getNotifications (boolean all, int userId, int deviceId, int groupId, boolean refresh) {
        String endpoint = "/notifications" +
                "?all=" + all +
                "&userId=" +userId+
                "&deviceId=" + deviceId+
                "&groupId=" + groupId+
                "&refresh=" + refresh;
        // Parameters (Tag+Parameter, RestMethod, Object Body, Response type)
        Notification Notification = RestHandler.sendRequest(endpoint, HttpMethod.GET, null, Notification.class);

        if (Notification == null)
            return null; // Pass null up so controller can detect session expiry

        return Notification;

    }


}
