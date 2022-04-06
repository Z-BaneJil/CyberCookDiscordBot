package ru.BaneJil.Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import ru.BaneJil.Bot.Cmds.*;
import ru.BaneJil.Bot.Config.BotConfig;


public class CyberCook extends ListenerAdapter {
    public static String prefix = BotConfig.botPrefix;

    public static JDABuilder builder;
    public static JDA bot;

    public static void startBot(String token) throws Exception {
        builder = JDABuilder.createLight(token,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGES);
        builder.addEventListeners(new CyberCook());
        builder.setActivity(Activity.playing(CmdsNames.HELP.getCmdName()));
        builder.setStatus(OnlineStatus.IDLE);
        bot = builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        Message msg = e.getMessage();

        if (!msg.getContentRaw().startsWith(prefix)) return;

        String[] command = msg.getContentRaw().split(" ");

        if (command[0].equalsIgnoreCase(CmdsNames.PING.getCmdName())) {
            if (command.length >= 2) {
                BotErrors.manyArgsError(e, command);
            } else {
                PingCmd.use(e);
            }
        }
        if (command[0].equalsIgnoreCase(CmdsNames.RANDOM.getCmdName())) {
            if (command.length >= 3) {
                BotErrors.manyArgsError(e, command);
            } else if (command.length <= 1) {
                BotErrors.fewArgsError(e, command);
            } else {
                RandomCmd.use(e, command);
            }
        }
        if (command[0].equalsIgnoreCase(CmdsNames.HELP.getCmdName())) {
            if (command.length >= 2) {
                BotErrors.manyArgsError(e, command);
            } else {
                HelpCmd.use(e);
            }
        }
        if (command[0].equalsIgnoreCase(CmdsNames.AUTHOR.getCmdName())) {
            if (command.length >= 3) {
                BotErrors.manyArgsError(e, command);
            } else if (command.length <= 1) {
                BotErrors.fewArgsError(e, command);
            } else {
                AuthorCmd.use(e, command);
            }
        }
        if (command[0].equalsIgnoreCase(CmdsNames.CHANGELOG.getCmdName())) {
            if (command.length >= 2) {
                BotErrors.manyArgsError(e, command);
            } else {
                ChangelogCmd.use(e);
            }
        }
    }

}