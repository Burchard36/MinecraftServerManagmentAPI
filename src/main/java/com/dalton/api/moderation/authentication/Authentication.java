package com.dalton.api.moderation.authentication;

import com.google.gson.JsonObject;

public class Authentication {

    private static String authKey;

    public Authentication(String key) {
        this.authKey = key;
    }

    public void setKey(String key) {
        this.authKey = key;
    }

    public static Boolean isAuth(String key) {
        return ("Bearer " + authKey).equals(key);
    }

    public static JsonObject getUnauthorized() {
        JsonObject object = new JsonObject();
        object.addProperty("message", "Incorrect authorization key.");
        return object;
    }

}
