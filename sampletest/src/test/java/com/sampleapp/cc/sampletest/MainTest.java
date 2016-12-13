package com.sampleapp.cc.sampletest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class MainTest {

    @Test(priority = 10)
    public void mytest() {
        Main m = new Main();
        Assert.assertNotNull(m);
    }

    @Test(priority = 20)
    public void mytestSkipped() {
        Main m = new Main();
        if (m != null) {
            throw new SkipException("This test has been skipped by condition");
        }
    }

    @Test(priority = 30)
    public void mytestFinish() {
        Main m = new Main();
        Assert.assertNotNull(m);
    }
}
