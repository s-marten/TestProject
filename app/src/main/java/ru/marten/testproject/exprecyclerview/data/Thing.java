package ru.marten.testproject.exprecyclerview.data;

/**
 * Created by marten on 15.09.16.
 */
public class Thing {

    private String name;
    private int weight;
    private String color;

    public Thing(String name, int weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
