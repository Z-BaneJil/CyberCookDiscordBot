package ru.BaneJil.Bot.Cmds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.internal.utils.Helpers;
import org.apache.commons.lang.math.NumberUtils;
import ru.BaneJil.Bot.BotErrors;

import java.awt.*;
import java.text.ParseException;

public class RandomCmd {
    private static final String[] wingmanMaps = {
            "Nuke",
            "Overpass",
            "Inferno",
            "Vertigo",
            "Lake",
            "Short-dust",
            "Train",
            "Cobblestone"
    };
    private static final String[] competitiveMaps = {
            "Nuke",
            "Overpass",
            "Inferno",
            "Vertigo",
            "Train",
            "Mirage",
            "Dust II",
            "Cache",
            "Office"
    };

    private static String randomMap(String[] maps) {
        int number = (int) Math.floor(Math.random() * maps.length);
        return maps[number];
    }

    private static Integer randomNumber(String command) {
        try {
            return (int) (Math.random() * Integer.parseInt(command.trim()));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void use(MessageReceivedEvent e, String[] command) {
        MessageChannel channel = e.getChannel();
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(232, 68, 68));
        embedBuilder.setTitle("Рандом", null);

        if (command[1].equalsIgnoreCase("напы")) {
            embedBuilder.setDescription(Helpers.format("Выпала карта: %s", randomMap(wingmanMaps)));
            channel.sendMessageEmbeds(embedBuilder.build()).queue();
        } else if (command[1].equalsIgnoreCase("мм")) {
            embedBuilder.setDescription(Helpers.format("Выпала карта: %s", randomMap(competitiveMaps)));
            channel.sendMessageEmbeds(embedBuilder.build()).queue();
        } else if(NumberUtils.isNumber(command[1])) {
            int number = randomNumber(command[1]);

            if (number == -1) {
                BotErrors.internalError(e, command);
                return;
            }

            embedBuilder.setDescription(Helpers.format("Выпало число: %d", number));
            channel.sendMessageEmbeds(embedBuilder.build()).queue();
        } else {
            BotErrors.invalidArgsError(e, command);
        }
    }
}