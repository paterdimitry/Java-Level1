package Lesson1;

public class Main {

    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();

    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;

        byte i = 0;
        short value = 1000;
        int count = 1;
        long sizeOfUniverse = 9999999512L;
        float costApple = 92.99f;
        double sizeOfAtom = 0.00000052;
        boolean CheckAnswer = true;
        char firstLetter = 'a';
        String greeting = "Hello!";

        //Вызов методов для проверки

        System.out.println(operation(5,10,4,3));
        System.out.println(checkSum(8,6));
        checkPositivityOfNumber(3);
        System.out.println(booleanCheckNegativityOfNumber(-3));
        outputGreeting("UserName");
        checkBissextileYear(2000);
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – входные параметры этого метода;

    public static double operation(double a, double b, double c, double d){
        return a * (b + c / d);
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий
    // что их сумма лежит в пределах от 10 до 20(включительно),
    // если да – вернуть true, в противном случае – false;

    public static boolean checkSum(double a, double b){
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    // положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.

    public static void checkPositivityOfNumber(int number){
        if (number >= 0)
            System.out.println("Положительное");
        else
            System.out.println("Отрицательное");
    }

    //6. Написать метод, которому в качестве параметра передается целое число,
    // метод должен вернуть true, если число отрицательное;

    public static boolean booleanCheckNegativityOfNumber(int number){
        return number < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;

    public static void outputGreeting(String name){
        System.out.println("Привет, " + name);
    }

    //8. * Написать метод, который определяет является ли год високосным,
    // и выводит сообщение в консоль. Каждый 4-й год является високосным,
    // кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static void checkBissextileYear(int year){
        //Чтобы год был високосным, должны выполняться условия одновременно:
        // 1. год делится без остатка на 4
        // 2. год делится без остатка на 400 ИЛИ с остатком на 100

        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
            System.out.println("Високосный");
        else
            System.out.println("Не високосный");
    }
}
