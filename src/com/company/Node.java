package com.company;

public class Node {

    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.println("ID " + person.id + " Имя: " + person.name + ",Возраст: " + person.age);
    }
}
