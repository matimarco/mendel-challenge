package com.challenge.mendel.Helper;

public class Helper {

    public static long getGeneratedLong() {
        long leftLimit = 1L;
        long rightLimit = 100000000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
}
