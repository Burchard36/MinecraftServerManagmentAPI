package com.dalton.api.moderation;

import com.dalton.api.moderation.authentication.Authentication;
import com.google.gson.JsonObject;

public class Handler {

    public static JsonObject handlRequest(Request request, spark.Request body, spark.Response response, String name) {
        if (request == Request.GET) {
            return handleGet(body, name);
        } else if (request == Request.POST){
            return handlePost(body, name);
        } else {
            response.status(400);
            JsonObject object = new JsonObject();
            object.addProperty("message", "Unknown point of entry (Method not found)");
        }
    }

    public static JsonObject handleGet(spark.Request request, String name) {
        SettingsManager.handleSettings(request, Request.GET, name);
        // Authenticate
        String key = request.headers("Authorization");
        if (key != null) {
            if (Authentication.isAuth(key)) {

            } else {

            }
        } else {
            JsonObject object = new JsonObject();
            object.addProperty("message", "No Authorization header provided.");
        }
    }

    public static JsonObject handlePost(spark.Request request, String name) {
        SettingsManager.handleSettings(request, Request.POST, name);
    }
}
