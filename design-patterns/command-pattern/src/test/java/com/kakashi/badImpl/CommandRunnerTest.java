package com.kakashi.badImpl;

import com.kakashi.TestHelpers;
import com.kakashi.manager.DatabaseManager;
import com.kakashi.manager.RechargeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandRunnerTest {

    CommandRunner commandRunner;

    @BeforeEach
    void setUp() {
        commandRunner = new CommandRunner(new DatabaseManager(), new RechargeManager());
    }

    @Test
    void testBalanceCheck() throws Exception {
        String balance = commandRunner.runCommand(TestHelpers.getTestBalanceCommand(
                Arrays.asList(TestHelpers.getTestUser())));
        assertEquals("1000", balance);
    }
}
