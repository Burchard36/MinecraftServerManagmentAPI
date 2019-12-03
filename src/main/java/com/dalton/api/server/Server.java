package com.dalton.api.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Server {

    public Server() {}

    public static JsonArray getOnlinePlayers() {
        JsonArray object = new JsonArray();
        for (Player p: Bukkit.getOnlinePlayers()) {
            object.add(p.getDisplayName());
        }
        return object;
    }

    public static JsonArray getOperators() {
        JsonArray object = new JsonArray();
        for (OfflinePlayer p: Bukkit.getOperators()) {
            object.add(p.getName());
        }
        return object;
    }

    public static JsonArray getWhitelistedPlayers() {
        JsonArray object = new JsonArray();
        for (OfflinePlayer p: Bukkit.getWhitelistedPlayers()) {
            object.add(p.getName());
        }
        return object;
    }

    public static JsonArray getBannedPlayers() {
        JsonArray object = new JsonArray();
        for (OfflinePlayer p: Bukkit.getBannedPlayers()) {
            object.add(p.getName());
        }
        return object;
    }

    public static JsonObject getServer() {
        JsonObject object = new JsonObject();
        object.addProperty("name", Bukkit.getName());
        object.addProperty("motd", Bukkit.getMotd());
        object.addProperty("ip", Bukkit.getIp());
        object.addProperty("port", Bukkit.getPort());
        object.addProperty("world_type", Bukkit.getWorldType());
        object.addProperty("allow_flight", Bukkit.getAllowFlight());
        object.addProperty("allow_nether", Bukkit.getAllowNether());
        object.addProperty("allow_end", Bukkit.getAllowEnd());
        object.addProperty("generate_structures", Bukkit.getGenerateStructures());
        object.addProperty("water_animal_spawn_limit", Bukkit.getWaterAnimalSpawnLimit());
        object.addProperty("monster_spawn_limit", Bukkit.getMonsterSpawnLimit());
        object.addProperty("animal_spawn_limit", Bukkit.getAnimalSpawnLimit());
        object.addProperty("ambient_spawn_limit", Bukkit.getAmbientSpawnLimit());
        object.addProperty("online_mode", Bukkit.getOnlineMode());
        object.addProperty("server_version", Bukkit.getBukkitVersion());
        object.addProperty("connection_throttle", Bukkit.getConnectionThrottle());
        object.addProperty("idle_timeout", Bukkit.getIdleTimeout());
        object.addProperty("spawn_radius", Bukkit.getSpawnRadius());
        object.addProperty("max_players", Bukkit.getMaxPlayers());
        object.addProperty("shutdown_message", Bukkit.getShutdownMessage());
        object.addProperty("ticks_per_animal_spawns", Bukkit.getTicksPerAnimalSpawns());
        object.addProperty("ticks_per_monster_spawns", Bukkit.getTicksPerMonsterSpawns());
        object.addProperty("view_distance", Bukkit.getViewDistance());
        object.addProperty("whitelisted", Bukkit.hasWhitelist());
        object.addProperty("hardcore", Bukkit.isHardcore());
        return object;
    }

}
