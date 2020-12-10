package Lesson6;

public class Cats extends Animals {

    private final int maxDistanceRun;
    private final int maxHeight;

    final int MIN_RUN_DIST = 100;
    final int MAX_RUN_DIST = 300;
    final int MIN_JUMP_HEIGHT = 150;
    final int MAX_JUMP_HEIGHT = 250;

    public Cats(String name) {
        super(name);
        maxDistanceRun = getRandomFromRange(MIN_RUN_DIST, MAX_RUN_DIST);
        maxHeight = getRandomFromRange(MIN_JUMP_HEIGHT, MAX_JUMP_HEIGHT);
    }

    @Override
    public void run(int distance) {
        if (distance <= maxDistanceRun)
            System.out.println("Кот " + name + " пробежал " + distance + " метров");
        else
            System.out.println("Кот " + name + " не смог пробежать " + distance + " метров, остановился на " + maxDistanceRun + " метрах");
    }

    @Override
    public void jump(int height) {
        if (height <= maxHeight)
            System.out.println("Кот " + name + " прыгнул на " + height + " сантиметров");
        else
            System.out.println("Кот " + name + " не смог прыгнуть на " + height + " сантиметров");
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
    }
}
