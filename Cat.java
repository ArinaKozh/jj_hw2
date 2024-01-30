package ru.geekbrains.junior.lesson2.hw2;

public class Cat extends Animal {
    private String[] sounds;

    public Cat(String name, int age) {
        super(name, age);
        this.sounds = null;
    }


    public void meow(){
        System.out.println("meow");
    }
}
