package ru.BaneJil.Bot.Cmds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class ChangelogCmd {
    public static void use(MessageReceivedEvent e) {
        MessageChannel channel = e.getChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(232, 68, 68));
        embedBuilder.setTitle("Изменения в версии 2.3.0", null);
        embedBuilder.setDescription("1. ```Исправление багов.```\n" +
                "2. ```Добавлен рандом чисел.```");

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
