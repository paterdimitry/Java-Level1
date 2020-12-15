package Lesson7;

public class Main {

    public static void main(String[] args) {
        //создаем котов
        final int NUMBER_OF_CATS = 5;
        Cat[] cat = new Cat[NUMBER_OF_CATS];
        initCats(cat);

        //создаем тарелку. В конструкторе класса осуществляется вызов ввода количества еды с клавиатуры
        Plate plate = new Plate();

        //даем всем котам поесть
        for (int i = 0; i < NUMBER_OF_CATS; i++) {
            cat[i].eat(plate);
            cat[i].printInfo();
        }

        // выводим остаток еды в тарелке
        plate.printInfo();
    }

    public static void initCats(Cat[] cat) {
        cat[0] = new Cat("Чубайс", 6);
        cat[1] = new Cat("Барсик", 3);
        cat[2] = new Cat("Кембербетч", 4);
        cat[3] = new Cat("Паралакс", 6);
        cat[4] = new Cat("Патрик", 5);
    }
}
