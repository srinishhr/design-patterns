package com.kakashi.goodImpl.executors;

import com.kakashi.beans.Command;
import com.kakashi.manager.DatabaseManager;

abstract public class CommandExecutor {

    protected DatabaseManager databaseManager;

    public CommandExecutor(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public String execute(final Command command) throws Exception {
        if(!isValid(command)) {

        }
        return executeValidCommand(command);
    }

    protected String getUser(final Command command) throws Exception {
        if(command.getParams().size() < 1){
            throw new Exception("Insufficient Params provided in command");
        }
        return command.getParams().get(0);
    }

    protected abstract String executeValidCommand(final Command command) throws Exception;

    protected abstract Boolean isValid(final Command command);

    public abstract Boolean isApplicable(final Command command);
}
