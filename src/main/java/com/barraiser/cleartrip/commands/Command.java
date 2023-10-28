package com.barraiser.cleartrip.commands;

public interface Command {

    boolean matches(String cmd);

    void execute(String cmd);
}
