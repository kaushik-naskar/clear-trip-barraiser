package com.barraiser.cleartrip.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandExecutor {

    private final List<Command> commands;

    public CommandExecutor(List<Command> commands) {
        this.commands = commands;
    }

    public void execute(String cmd) {
        for (Command command : commands) {
            if (command.matches(cmd)) {
                command.execute(cmd);
            }
        }
    }
}
