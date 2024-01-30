package ru.geekbrains.junior.lesson2.hw2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        Class clazz = null;
        Class clazzAnimal = null;
        try {
            clazz = Class.forName("ru.geekbrains.junior.lesson2.hw2.Cat");
            Constructor[] constructors = clazz.getConstructors();
            clazzAnimal = Class.forName("ru.geekbrains.junior.lesson2.hw2.Animal");
            Field age = clazzAnimal.getDeclaredField("age");
            age.setAccessible(true);
            Field name = clazzAnimal.getDeclaredField("name");
            name.setAccessible(true);
            ArrayList<Animal> animalList = new ArrayList<>();
            String[] catNames = {"Pet","Purr","Snow","Puff","Oleg"};
            String[] dogNames = {"Igor","Barky","Lily","Bella","Vyasya"};
            for(int i=1;i<6;i++) {
                Animal cat = (Cat) constructors[0].newInstance("f", 5);
                age.set(cat, ThreadLocalRandom.current().nextInt(1,6));
                name.set(cat, catNames[i-1]);
                animalList.add(cat);
            }
            clazz = Class.forName("ru.geekbrains.junior.lesson2.hw2.Dog");
            Constructor[] constructorsDog = clazz.getConstructors();
            for(int i=1;i<6;i++) {
                Animal dog = (Dog) constructorsDog[0].newInstance("f",5);
                age.set(dog, ThreadLocalRandom.current().nextInt(5,11));
                name.set(dog, dogNames[i-1]);
                animalList.add(dog);
            }
            Collections.shuffle(animalList);
            for (Animal animal:animalList) {
                System.out.println(animal);
                if (animal instanceof Cat){
                    ((Cat) animal).meow();
                }
                else if (animal instanceof Dog){
                    ((Dog) animal).bark();
                }

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
