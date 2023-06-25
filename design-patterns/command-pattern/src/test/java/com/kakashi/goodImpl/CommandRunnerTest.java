package com.kakashi.goodImpl;

import com.kakashi.TestHelpers;
import com.kakashi.goodImpl.CommandRunner;
import com.kakashi.goodImpl.executors.BalanceExecutor;
import com.kakashi.goodImpl.executors.RechargeExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandRunnerTest {

    CommandRunner commandRunner;

    @BeforeEach
    public void setup(){
        commandRunner = new CommandRunner(Arrays.asList(
                new BalanceExecutor(TestHelpers.getDatabaseManager()),
                new RechargeExecutor(TestHelpers.getDatabaseManager(), TestHelpers.getRechargeManager())
        ));
    }

    @Test
    void testBalanceCheck() {
        String balance = commandRunner.runCommand(TestHelpers.getTestBalanceCommand(Arrays.asList(TestHelpers.getTestUser())));
        assertEquals("1000", balance);
    }
}
