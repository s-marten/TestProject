package ru.marten.testproject.exprecyclerview.data;

/**
 * Created by marten on 15.09.16.
 */
public class Animal {

    private String name;
    private int weight;
    private boolean sex;

    public Animal(String name, int weight, boolean sex) {
        this.name = name;
        this.weight = weight;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}

