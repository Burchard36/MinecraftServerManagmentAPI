package com.dalton.routes;

import org.bukkit.plugin.Plugin;

import static spark.Spark.*;

public class ServerPostRoutes {

    public static void run(Plugin pl) {

        post("/server/ban", "application/json", (((request, response) -> {
            return request.body();
        })));

        post("/server/whitelsit", (((request, response) -> {
            return "temp";
        })));

    }
}
