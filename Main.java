package Lesson6;

public class Main {

    public static void main(String[] args) {
        Cats cat1 = new Cats("Чубайс");
        Cats cat2 = new Cats("Барсик");
        Dogs dog1 = new Dogs("Жучка");
        //Проверка
        cat1.run(30);
        cat2.run(400);
        cat1.swim(30);
        cat2.jump(40);
        dog1.run(500);
        dog1.jump(50);
        dog1.swim(10);
         }
}
