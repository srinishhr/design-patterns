package com.kakashi.badImpl;

import com.kakashi.beans.Command;
import com.kakashi.manager.DatabaseManager;
import com.kakashi.manager.RechargeManager;

public class CommandRunner {

    final DatabaseManager databaseManager;
    final RechargeManager rechargeManager;

    public CommandRunner(DatabaseManager databaseManager, RechargeManager rechargeManager) {
        this.databaseManager = databaseManager;
        this.rechargeManager = rechargeManager;
    }

    public String runCommand(Command command) throws Exception {
        if("balance".equalsIgnoreCase(command.getName())) {
            if(command.getParams().size() != 1) {
                return "Invalid Command";
            }
            String userStr = getUser(command);
            return databaseManager.getUserBalance(userStr).toString();
        } else if("recharge".equalsIgnoreCase(command.getName())) {
            if(command.getParams().size() != 2) {
                return "Invalid Command";
            }
            String userStr = getUser(command);
            Integer userBalance = databaseManager.getUserBalance(userStr);
            Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

            if(userBalance < rechargeAmount) {
                return "Insufficient User balance";
            }
            rechargeManager.recharge(userStr, rechargeAmount);
            return "Recharge done";
        } else {
            return "Invalid Command";
        }
    }

    private String getUser(final Command command) throws Exception {
        if(command.getParams().size() < 1){
            throw new Exception("Insufficient Params provided in command");
        }
        return command.getParams().get(0);
    }
}
