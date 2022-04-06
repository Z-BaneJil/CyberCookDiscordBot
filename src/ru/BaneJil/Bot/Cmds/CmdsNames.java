package ru.BaneJil.Bot.Cmds;

import ru.BaneJil.Bot.Config.BotConfig;

public enum CmdsNames {
    PING("пинг"),
    HELP("помощь"),
    AUTHOR("автор"),
    RANDOM("рандом"),
    CHANGELOG("обнова");

    private final String cmdName;

    CmdsNames(String cmdName) {
        this.cmdName = cmdName;
    }

    public String getCmdName() {
        return BotConfig.botPrefix + cmdName;
    }
}