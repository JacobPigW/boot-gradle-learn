package com.jacob.learn.utils;

public class DefaultProps {
    public final static String DEFAULT_PROPS =
            "a = a\n" +
            "b = b\n" +
            "\n" +
            "\n" +
            "[cpu]\n" +
            "a = a\n" +
            "b = b\n" +
            "c = c\n";

    public static int getDbnamePostfix(String ip) {
        return Math.abs(ip.hashCode() % 9) + 1;
    }
}
