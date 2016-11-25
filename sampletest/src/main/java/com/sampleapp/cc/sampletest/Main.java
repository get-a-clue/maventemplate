package com.sampleapp.cc.sampletest;

import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");

        String str = null;
        if (StringUtils.isEmpty(str)) {
            System.out.println("------- Success!!!");
        }
    }

}
