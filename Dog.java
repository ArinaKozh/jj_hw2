package ru.geekbrains.junior.lesson2.hw2;

public class Dog extends Animal{
    private String[] commands;

    public Dog(String name, int age) {
        super(name, age);
        this.commands = null;
    }


    public void bark(){
        System.out.println("voof");
    }
}
