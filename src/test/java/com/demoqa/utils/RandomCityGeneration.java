package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RandomCityGeneration {
    private final Faker faker;
    private final Map<String, String[]> stateToCitiesMap;

    public RandomCityGeneration() {
        this.faker = new Faker();
        this.stateToCitiesMap = new HashMap<>();
        initializeStateToCitiesMap();
    }

    private void initializeStateToCitiesMap() {
        stateToCitiesMap.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateToCitiesMap.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateToCitiesMap.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateToCitiesMap.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }

    private String[] getStatesAsArray() {
        Set<String> keySet = stateToCitiesMap.keySet();
        return keySet.toArray(new String[0]);
    }

    public String getRandomState() {
        return faker.options().option(getStatesAsArray());
    }

    public String getRandomCity(String state) {
        String[] cities = stateToCitiesMap.get(state);
        return faker.options().option(cities);
    }
}
