package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animalList=new ArrayList<>();
        ArrayList<Dog> dogList=new ArrayList<>();
        ArrayList<Cat> catList=new ArrayList<>();

        /*Animal dog = new Dog("cookie", "lab");
        //Animal cat = new Cat();

        dog.makeSound();
        //cat.makeSound();*/

        Animal newanimal= new Dog("cookie","lab");
        newanimal.makeSound();
        newanimal= new Cat("luna");
        newanimal.eat();
        newanimal.add(newanimal);
        for (Animal animal:animallLst){
            if (animal instanceof Dog){
                ((Dog)animal).howl();
            }
            else{
                ((Cat)animal).makeSound();
            }
        }
    }
}