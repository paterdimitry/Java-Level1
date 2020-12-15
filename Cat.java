package Lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false; //сытость. по умолчанию кот голоден
    }

    public void eat(Plate plate) {
        satiety = plate.decreaseFood(appetite); //если кот смог поесть, сытость становится true
    }

    public void printInfo() {
        System.out.println("Кот " + name + (satiety ? " наелся" : " остался голоден")); //выводим информацию, наелся ли кот
    }
}
