package com.kakashi;

import com.kakashi.beans.Command;
import com.kakashi.manager.DatabaseManager;
import com.kakashi.manager.RechargeManager;

import java.util.List;

public class TestHelpers {

    public static DatabaseManager getDatabaseManager() {
        return new DatabaseManager();
    }

    public static RechargeManager getRechargeManager() {
        return new RechargeManager();
    }

    public static String getTestUser() {
        return "test-user";
    }

    public static Command getTestBalanceCommand(List params) {
        return new Command("balance", params);
    }

    public static Command getTestRechargeCommand(List params) {
        return new Command("recharge", params);
    }
}
