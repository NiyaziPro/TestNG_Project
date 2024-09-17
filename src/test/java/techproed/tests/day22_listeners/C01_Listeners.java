package techproed.tests.day22_listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.util.NoSuchElementException;


@Listeners(techproed.utilities.Listeners.class)

public class C01_Listeners {


    @Test
    public void testListenersUsagePassed() {

        System.out.println("Passed");
        Assert.assertTrue(true);


    }

    @Test
    public void testListenersUsageFailed() {
        System.out.println("Failed");
        Assert.assertTrue(false);

    }

    @Test
    public void testListenersUsageSkip() {
        System.out.println("Skipped");
        throw new SkipException("Skipped");

    }

    @Test
    public void testListenersUsageException() {
        System.out.println("Error");
        throw new NoSuchElementException("NoSuchElementException");

    }

}
