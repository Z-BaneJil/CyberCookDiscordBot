package ru.BaneJil.Bot.Cmds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.internal.utils.Helpers;
import ru.BaneJil.Bot.Config.BotConfig;

import java.awt.*;

public class HelpCmd {
    public static void use(MessageReceivedEvent e) {
        MessageChannel channel = e.getChannel();

        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(new Color(232, 68, 68));
        embedBuilder.setTitle("Помощь", null);
        embedBuilder.setDescription(Helpers.format("1. ```%s <напы/мм/\"число\"> - Выбирает рандомную карту или число.```\n" +
                "2. ```%s <steam/youtube> - показывает выбранную соц. сеть автора бота.```\n" +
                "3. ```%s - показывает версию бота и изменения в ней.```\n" +
                "4. ```%s - показывает это меню.```\n" +
                "5. ```%s - префикс у команд.```",
                CmdsNames.RANDOM.getCmdName(),
                CmdsNames.AUTHOR.getCmdName(),
                CmdsNames.CHANGELOG.getCmdName(),
                CmdsNames.HELP.getCmdName(),
                BotConfig.botPrefix));

        channel.sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
