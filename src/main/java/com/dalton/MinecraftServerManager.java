package com.dalton;

import static spark.Spark.*;

import com.dalton.api.moderation.authentication.Authentication;
import com.dalton.routes.ServerGetRoutes;
import com.dalton.routes.ServerPostRoutes;
import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MinecraftServerManager extends JavaPlugin {

    private int port;
    private String serverPassword;
    private static Plugin pl;

    private Authentication authentication;

    public void onEnable() {
        // Plugin startup logic
        pl = this;
        File file = new File(getDataFolder(), "/config.yml");
        if (!file.exists()) {
            saveDefaultConfig();
            getConfig().set("Server.Key", RandomStringUtils.randomAlphabetic(10));
            saveConfig();
        }

        port = getConfig().getInt("Server.Port");
        serverPassword = getConfig().getString("Server.Key");
        authentication = new Authentication(serverPassword);

        // Start the server
        port(port);
        ServerGetRoutes.run(this);
        ServerPostRoutes.run(this);
        Bukkit.getLogger().info(textOf("&bMinecraft Server API running on port &e" + port));


    }

    public void onDisable() {
        // Plugin shutdown logic
        pl = null;
        stop();

        ServerGetRoutes.stop();
    }

    public static String textOf(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static Plugin getInstance() {
        return pl;
    }
}

