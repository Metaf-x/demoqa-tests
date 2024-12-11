package com.demoqa.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public String getRandomPhone() {
        return String.format("%s%s%s", 7, getRandomInt(900, 999), getRandomInt(1111111, 9999999));
    }
}
