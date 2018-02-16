package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import java.security.SecureRandom;

/**
 * Return a random string.
 * Created by Joshua on 5/3/2017.
 */

public class RandomString {
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String get(int min, int max) {
        SecureRandom rnd = new SecureRandom();
        int rndLen = rnd.nextInt(max - min) + min;

        StringBuilder sb = new StringBuilder(rndLen);
        for( int i = 0; i < rndLen; i++ ) {
            sb.append(CHARS.charAt(rnd.nextInt(CHARS.length())));
        }
        return sb.toString();
    }


}
