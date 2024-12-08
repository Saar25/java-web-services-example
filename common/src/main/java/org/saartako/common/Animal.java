package org.saartako.common;

public record Animal(String type, String name, int weight) {

    @Override
    public String toString() {
        return name + " (" + type + ", " + weight + "kg)";
    }
}