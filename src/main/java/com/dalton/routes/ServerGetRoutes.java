package com.dalton.routes;


import com.dalton.api.moderation.Handler;
import com.dalton.api.moderation.Request;
import com.dalton.api.moderation.authentication.Authentication;
import com.dalton.api.server.Server;
import org.bukkit.plugin.Plugin;

import static spark.Spark.*;

public class ServerGetRoutes {

    private static String auth = "Authorization";
    private static Plugin plugin;

    public static void run(Plugin pl){
        plugin = pl;

        /**
         * @returns information about the server (Name, MOTD, etc...)
         */
        get("/server", (request, response) -> {
            Handler.handlRequest(Request.GET, request);
            if (!Authentication.isAuth(request.headers(auth))) {
                response.status(401);
                return Authentication.getUnauthorized();
            } else {
                response.status(200);
                return Server.getServer();
            }
        });

        /**
         * @returns A array of online players
         */
        get("/server/players", ((request, response) -> {
            if (!Authentication.isAuth(request.headers(auth))) {
                response.status(401);
                return Authentication.getUnauthorized();
            } else {
                response.status(200);
                return Server.getOnlinePlayers();
            }
        }));

        /**
         * @returns  A array of server operators
         */
        get("/server/operators", ((request, response) -> {

            if (!Authentication.isAuth(request.headers(auth))) {
                response.status(401);
                return Authentication.getUnauthorized();
            } else {
                response.status(200);
                return Server.getOperators();
            }
        }));

        /**
         * @returns A array of whitelisted players
         */
        get("/server/whitelisted", ((request, response) -> {
            if (!Authentication.isAuth(auth)) {
                response.status(401);
                return Authentication.getUnauthorized();
            } else {
                response.status(200);
                return Server.getWhitelistedPlayers();
            }
        }));

        /**
         * @returns A array of banned players
         */
        get("/server/banned", ((request, response) -> {
            if (!Authentication.isAuth(auth)) {
                response.status(401);
                return Authentication.getUnauthorized();
            } else {
                response.status(200);
                return Server.getBannedPlayers();
            }
        }));
    }

    public static void stop() {
        plugin = null;
    }
}
