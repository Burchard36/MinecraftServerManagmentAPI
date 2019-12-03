package com.dalton.api.moderation;

import com.dalton.MinecraftServerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import spark.Request;
import spark.Response;

public class SettingsManager {

    private static Plugin plugin = MinecraftServerManager.getInstance();

    public static void handleSettings(Request request, com.dalton.api.moderation.Request req, String name) {
        if (req == com.dalton.api.moderation.Request.GET) {
            getSettings(request, name);
        } else if (req == com.dalton.api.moderation.Request.POST) {
            postSettings(request, name);
        }
    }

    public static void getSettings(Request request, String name) {
        boolean logGetRequests = plugin.getConfig().getBoolean("Server.Moderation.LogGetRequests");
        if (logGetRequests) {
            String message = MinecraftServerManager.textOf("&bGET Request from &e" + request.ip() + "&0.&b Routing to &e" + name + "&0.");
            Bukkit.getLogger().info(message);
        }
    }

    public static void postSettings(Request request, String name) {
        boolean logPostRequests = plugin.getConfig().getBoolean("Server.Moderation.LogPostRequests");
        if (logPostRequests) {
            String message = MinecraftServerManager.textOf("&bPOST Request from &e" + request.ip() + "&0.&b Routing to &e" + name + "&0.");
            Bukkit.getLogger().info(message);
        }
    }
}
