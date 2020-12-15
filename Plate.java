package Lesson7;

import java.util.Scanner;

public class Plate {
    private int food;

    public Plate() {
        this.food = setFood();
    }

    //метод для ввода количества еды
    private int setFood() {
        Scanner in = new Scanner(System.in);
        int food;
        System.out.println("Сколько еды положить в тарелку?");
        while (true) {
            food = in.nextInt();
            if (food > 0)
                break;
            else
                System.out.println("Введите корректное количество еды в тарелке");
        }
        return food;
    }
    //сделаем метод еды из тарелки типа boolean. В итоге он говорит, смог ли поесть кот.
    //Одновременно защищаем тарелку от отрицательного количества еды
    public boolean decreaseFood(int n) {
        if (food >= n)
            food -= n;
        else
            return false;
        return true;
    }

    //метод для добавления еды в тарелку
    public void increaseFood() {
        food += setFood();
        printInfo();
    }

    public void printInfo() {
        System.out.println("В тарелке еды: " + food);
    }
}
