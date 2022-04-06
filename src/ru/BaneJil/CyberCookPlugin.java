package ru.BaneJil;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;
import ru.BaneJil.Bot.Config.BotConfig;
import ru.BaneJil.Bot.CyberCook;

import java.util.logging.Logger;

public class CyberCookPlugin extends JavaPlugin {
    public static Server server = Bukkit.getServer();
    public static Logger logger = server.getLogger();

    public static String token = BotConfig.botToken;

    @Override
    public void onEnable() {
        try {
            CyberCook.startBot(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("CyberCookPlugin launched");
    }
}