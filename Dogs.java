package Lesson6;

public class Dogs extends Animals{

    private final int maxDistanceRun;
    private final int maxHeight;
    private final int maxDistanceSwim;

    final int MIN_RUN_DIST = 400;
    final int MAX_RUN_DIST = 600;
    final int MIN_JUMP_HEIGHT = 40;
    final int MAX_JUMP_HEIGHT = 60;
    final int MIN_SWIM_DIST = 8;
    final int MAX_SWIM_DIST = 15;


    public Dogs(String name) {
        super(name);
        maxDistanceRun = getRandomFromRange(MIN_RUN_DIST, MAX_RUN_DIST);
        maxHeight = getRandomFromRange(MIN_JUMP_HEIGHT, MAX_JUMP_HEIGHT);
        maxDistanceSwim = getRandomFromRange(MIN_SWIM_DIST, MAX_SWIM_DIST);
    }

    @Override
    public void run(int distance) {
        if (distance <= maxDistanceRun)
            System.out.println("Собака " + name + " пробежала " + distance + " метров");
        else
            System.out.println("Собака " + name + " не смогла пробежать " + distance + " метров, остановилась на " + maxDistanceRun + " метрах");
    }

    @Override
    public void jump(int height) {
        if (height <= maxHeight)
            System.out.println("Собака " + name + " прыгнула на " + height + " сантиметров");
        else
            System.out.println("Собака " + name + " не смогла прыгнуть на " + height + " сантиметров");
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxDistanceSwim)
            System.out.println("Собака " + name + " проплыла " + distance + " метров");
        else
            System.out.println("Собака " + name + " не смогла проплыть " + distance + " метров, утонула на " + maxDistanceSwim + " метрах");
    }
}
