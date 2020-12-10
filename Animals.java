package Lesson6;

import java.util.Random;

public abstract class Animals {

    public String name;

    public Animals() {
        System.err.println("Животное без имени!");
        }

    public Animals(String name) {
        this.name = name;
    }

    public abstract void run(int distance);

    public abstract void jump(int height);

    public abstract void swim(int distance);

    public int getRandomFromRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)) + min;
    }
}
