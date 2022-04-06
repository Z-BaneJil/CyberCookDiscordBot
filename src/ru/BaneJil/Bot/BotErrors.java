package ru.BaneJil.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.internal.utils.Helpers;
import ru.BaneJil.Bot.Cmds.CmdsNames;

import java.awt.*;

public class BotErrors {
    public static void manyArgsError(MessageReceivedEvent e, String[] command) {
        MessageChannel channel = e.getChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(232, 68, 68));
        embedBuilder.setTitle("Ошибка");
        embedBuilder.setDescription(Helpers.format("```Много аргументов к команде: \"%s\"!```" +
                "```Смотрите: \"%s\".```", command[0], CmdsNames.HELP.getCmdName()));

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
    public static void fewArgsError(MessageReceivedEvent e, String[] command) {
        MessageChannel channel = e.getChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(232, 68, 68));
        embedBuilder.setTitle("Ошибка");
        embedBuilder.setDescription(Helpers.format("```Моло аргументов к команде: \"%s\"!```" +
                "```Смотрите: \"%s\".```", command[0], CmdsNames.HELP.getCmdName()));

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
    public static void invalidArgsError(MessageReceivedEvent e, String[] command) {
        MessageChannel channel = e.getChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(232, 68, 68));
        embedBuilder.setTitle("Ошибка");
        embedBuilder.setDescription(Helpers.format("```Неверные аргументы к команде: \"%s\"!```" +
                "```Смотрите: \"%s\".```", command[0], CmdsNames.HELP.getCmdName()));

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}