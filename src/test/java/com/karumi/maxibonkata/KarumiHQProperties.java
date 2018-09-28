package com.karumi.maxibonkata;

import static junit.framework.TestCase.assertTrue;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

/**
 * Created by Adalberto Plaza on 28/09/2018.
 */
@RunWith(JUnitQuickcheck.class)
public class KarumiHQProperties {

    @Mock Chat chat;

    private KarumiHQs karumiHQs;

    @Test
    public void name() {
        initHQ();

        assertTrue(karumiHQs.getMaxibonsLeft() == 10);
    }

    @Property
    public void openFridgeWithOneDeveloper(@From(DevelopersGenerator.class) Developer developer) {
        initHQ();

        karumiHQs.openFridge(developer);

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }

    @Property
    public void openFridgeWithMultipleDeveloper(List<@From(DevelopersGenerator.class) Developer> developers) {
        initHQ();

        karumiHQs.openFridge(developers);

        assertTrue(karumiHQs.getMaxibonsLeft() >= 2);
    }

    @Property
    public void messageSentWhenBuyMaxibombs(@From(HungryDevelopersGenerator.class) Developer developer) {
        initHQ();

        karumiHQs.openFridge(developer);

        String messageToSent = "Hi guys, I'm " + developer.getName() + ". We need more maxibons!";
        verify(chat, times(1)).sendMessage(messageToSent);
    }

    private void initHQ() {
        chat = Mockito.mock(Chat.class);
        karumiHQs = new KarumiHQs(chat);
    }

}
