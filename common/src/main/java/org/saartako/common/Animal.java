package org.saartako.common;

public class Animal {

    private final String type;
    private final String name;
    private final int weight;

    public Animal(String type, String name, int weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}