package com.huatech.mall.tree;

/**
 * @author like
 * @date 2021-01-25 9:26 上午
 **/
public class Person  implements  Comparable<Person>{

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                age +
                '}';
    }
}