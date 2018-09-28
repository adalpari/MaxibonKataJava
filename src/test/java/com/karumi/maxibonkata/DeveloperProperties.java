package com.karumi.maxibonkata;

import static junit.framework.TestCase.assertEquals;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.runner.RunWith;

/**
 * Created by Adalberto Plaza on 28/09/2018.
 */
@RunWith(JUnitQuickcheck.class)
public class DeveloperProperties {

    private final static String NAME = "Karumi";

    @Property
    public void theNameIsConfigured(String name) {
        Developer developer = new Developer(name, 1);

        assertEquals(name, developer.getName());
    }

    @Property
    public void theMaxibombsAreConfiguredInPositive(@From(PositiveNumberGenerator.class) int maxibombsToGrab) {
        Developer developer = new Developer(NAME, maxibombsToGrab);

        assertEquals(maxibombsToGrab, developer.getNumberOfMaxibonsToGrab());
    }

    @Property
    public void theMaxibombsAreConfiguredInNegativeOrZero(@From(NegativeAndZeroNumberGenerator.class) int maxibombsToGrab) {
        Developer developer = new Developer(NAME, maxibombsToGrab);

        assertEquals(0, developer.getNumberOfMaxibonsToGrab());
    }
}
