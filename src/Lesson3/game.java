package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class game {

    //Создадим глобальные объекты, в том числе массив со словами
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        sayHello();
        doGame();
    }

    private static void sayHello() {
        System.out.println("Вам предлагается игра, в которой необходимо угадать слово");
        System.out.println("Одно из следующих слов будет загадано:");
        System.out.println(Arrays.toString(words));
    }

    private static void doGame() {
        String rightAnswer = "";
        while (true) {
            rightAnswer = takeRandomWord();
            checkAnswer(rightAnswer);
            doExit();
        }
    }

    private static String takeRandomWord() {
        return words[random.nextInt(words.length)];
    }

    private static void checkAnswer(String rightAnswer) {
        String answer = takeAnswer();
        if (answer.equals(rightAnswer)) {
            System.out.println("Вы угадали! Поздравляем!");
        } else {
            System.out.println("Проверка совпадений: " + checkCharsInAnswer(answer, rightAnswer));
            System.out.println("Попробуйте ещё раз: ");
            checkAnswer(rightAnswer);
        }
    }

    private static String takeAnswer() {
        System.out.print("Введите ваше слово: ");
        String answer = scanner.next();
        return answer.toLowerCase(); //создаем незавимисость от регистра букв
    }

    private static String checkCharsInAnswer(String answer, String rightAnswer) {
        String note = "";
        //Проверка букв на своих местах
        for (int i = 0; i < answer.length() & i < rightAnswer.length(); i++) {
            if (answer.charAt(i) == rightAnswer.charAt(i)) {
                note += answer.charAt(i);
            } else {
                note += "#";
            }
        }

        //Дописываем символ # до общей длины в 15 символов
        for (int i = note.length(); i < 15; i++) {
            note += "#";
        }
        return note;
    }

    private static void doExit() {
        System.out.println("Хотите сыграть еще раз? Введите 1 для продолжения или 0 для выхода");

        switch (scanner.next()) {
            case "0":
                System.exit(0);
                break;
            case "1":
                break;
            default:
                doExit();
        }
    }
}
