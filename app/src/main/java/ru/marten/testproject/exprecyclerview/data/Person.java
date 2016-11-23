package ru.marten.testproject.exprecyclerview.data;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by marten on 15.09.16.
 */
public class Person {

    private String name;
    private int weight;
    private boolean sex;

    public Person(String name, int weight, boolean sex) {
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

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public boolean getSex() {
        return sex;
    }


    public static ArrayList<Person> getTestPersonList() {
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Masha", 45, false));
        list.add(new Person("Misha", 50, true));
        list.add(new Person("Kolya", 77, true));
        list.add(new Person("Diana", 30, false));
        list.add(new Person("Liza", 39, false));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));
        list.add(new Person("Vasya", 55, true));



        return list;
    }

    public static ArrayList<String> getHeaders() {
        ArrayList<String> list = new ArrayList<>();

        list.add("male");
        list.add("female");

        return list;
    }
}
