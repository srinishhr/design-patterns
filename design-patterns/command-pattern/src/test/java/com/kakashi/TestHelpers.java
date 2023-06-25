package com.kakashi;

import com.kakashi.beans.Command;

import java.util.List;

public class TestHelpers {

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
