package com.github.daimLiat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

public class MagicBallTest {
    @Test
    public void testLucky() {
        // shake-shake
        Assertions.assertEquals(7, MagicBall.getLucky());
    }
}
