package com.kakashi.goodImpl.executors;

import com.kakashi.beans.Command;
import com.kakashi.manager.DatabaseManager;
import com.kakashi.manager.RechargeManager;

public class RechargeExecutor extends CommandExecutor {

    public static final String RECHARGE = "recharge";
    private final RechargeManager rechargeManager;

    public RechargeExecutor(DatabaseManager databaseManager, RechargeManager rechargeManager) {
        super(databaseManager);
        this.rechargeManager = rechargeManager;
    }

    @Override
    protected String executeValidCommand(Command command) throws Exception {
        String userStr = getUser(command);
        Integer userBalance = databaseManager.getUserBalance(userStr);
        Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

        if(userBalance < rechargeAmount) {
            return "Insufficient User balance";
        }
        rechargeManager.recharge(userStr, rechargeAmount);
        return "Recharge done";
    }

    @Override
    protected Boolean isValid(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    public Boolean isApplicable(Command command) {
        return command.getName().equalsIgnoreCase(RECHARGE);
    }
}
