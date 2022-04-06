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
        embedBuilder.setTitle("Изменения в версии 2.2.0", null);
        embedBuilder.setDescription("1. ```Код бота, исправлен для простоты развития.```\n" +
                "2. ```Команда рандом, тоже помещена в табличку, так как сильно контрастировала на фоне остальных команд.```");

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
