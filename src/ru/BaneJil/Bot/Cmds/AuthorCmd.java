package ru.BaneJil.Bot.Cmds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import ru.BaneJil.Bot.BotErrors;

import java.awt.*;

public class AuthorCmd {
    public static void use(MessageReceivedEvent e, String[] command) {
        MessageChannel channel = e.getChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(232, 68, 68));

        if (command[1].equalsIgnoreCase("steam")) {
            embedBuilder.setTitle("Steam автора", "https://steamcommunity.com/id/BaneJil/");
            embedBuilder.setDescription("Это Steam автора, сделай что-нибудь по дружески.");

            channel.sendMessageEmbeds(embedBuilder.build()).queue();
        } else if (command[1].equalsIgnoreCase("youtube")) {
            embedBuilder.setTitle("YouTube автора", "https://www.youtube.com/channel/UCKYeLsPTd5_uVBYWz4dYaKw");
            embedBuilder.setDescription("Это YouTube автора, сделай что-нибудь по дружески.");

            channel.sendMessageEmbeds(embedBuilder.build()).queue();
        } else {
            BotErrors.invalidArgsError(e, command);
        }
    }
}
