package com.karumi.maxibonkata;

import static junit.framework.TestCase.assertTrue;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by Adalberto Plaza on 28/09/2018.
 */
@RunWith(JUnitQuickcheck.class)
public class KarumiHQProperties {

    private KarumiHQs karumiHQs;

    @Before
    public void setUp() {
        karumiHQs = new KarumiHQs();
    }

    @Test
    public void name() {
        KarumiHQs karumiHQs = new KarumiHQs();

        assertTrue(karumiHQs.getMaxibonsLeft() == 10);
    }

    @Property
    public void openFridgeWithOneDeveloper(@From(DevelopersGenerator.class) Developer developer) {
        karumiHQs.openFridge(developer);

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }

    @Property
    public void openFridgeWithMultipleDeveloper(List<@From(DevelopersGenerator.class) Developer> developers) {
        karumiHQs.openFridge(developers);

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }
}
