package com.kakashi.goodImpl;

import com.kakashi.beans.Command;
import com.kakashi.goodImpl.executors.CommandExecutor;

import java.util.List;

public class CommandRunner {
    List<CommandExecutor> listOfCommandExecutor;

    public CommandRunner(List<CommandExecutor> listOfCommandExecutor) {
        this.listOfCommandExecutor = listOfCommandExecutor;
    }

    public String runCommand(Command command) {
        try {
            for (CommandExecutor commandExecutor : listOfCommandExecutor) {
                if (commandExecutor.isApplicable(command)) {
                    return commandExecutor.execute(command);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Invalid Command";
    }
}
