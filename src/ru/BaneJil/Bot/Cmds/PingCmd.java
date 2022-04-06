package ru.BaneJil.Bot.Cmds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.internal.utils.Helpers;

import java.awt.*;

public class PingCmd {
    public static void use(MessageReceivedEvent e) {
        MessageChannel channel = e.getChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setTitle("Понг!", null);
        embedBuilder.setColor(new Color(232, 68, 68));
        embedBuilder.setDescription(Helpers.format("Привет, %s! " +
                "Смысла показывать пинг нету. Ты бы увидел пинг между тобой и ботом, а не серверами CS:GO.",
                e.getAuthor().getAsMention()));

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}