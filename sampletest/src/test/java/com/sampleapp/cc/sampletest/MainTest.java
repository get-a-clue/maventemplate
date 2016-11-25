package com.sampleapp.cc.sampletest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void mytest() {
        Main m = new Main();
        Assert.assertNotNull(m);
    }
}
