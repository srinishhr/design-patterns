package com.kakashi.goodImpl.executors;

import com.kakashi.beans.Command;
import com.kakashi.manager.DatabaseManager;

public class BalanceExecutor extends CommandExecutor {

    public static final String BALANCE = "balance";

    public BalanceExecutor(DatabaseManager databaseManager) {
        super(databaseManager);
    }

    @Override
    protected String executeValidCommand(Command command) throws Exception {
        String userStr = getUser(command);
        return databaseManager.getUserBalance(userStr).toString();
    }

    @Override

    protected Boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    public Boolean isApplicable(Command command) {
        return command.getName().equalsIgnoreCase(BALANCE);
    }
}
