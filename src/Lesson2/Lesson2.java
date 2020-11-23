package Lesson2;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {

        invertArray();
        invertArray2();
        invertArray3();
        System.out.println(Arrays.toString(fillArray()));
        System.out.println(Arrays.toString(changeArray()));
        fillDiagonal();
        double[] arr = {1, 7, 5.59, -3.27, 10.71, -6.53, 3.47, 2};
        minAndMaxElements(arr);
        int[] intArr = {1, 1, 2, 1, 3};
        System.out.println(checkBalance(intArr));
        int[] shiftArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 1;
        System.out.println(Arrays.toString(shiftArray(shiftArr, n)));

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;


    //Проверку на соответствие элементов массива на равенство 0 или 1 не производим. Считаем, что массив заполнен правильно.
    //Вариант 1. Через if-else
    public static void invertArray() {
        int[] integerArray = {1, 0, 1, 1, 1, 0, 0, 1};
        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] == 1) {
                integerArray[i] = 0;
            } else {
                integerArray[i] = 1;
            }
        }
        System.out.println(Arrays.toString(integerArray));
    }

    //Вариант 2. Через switch-case
    public static void invertArray2() {
        int[] integerArray = {1, 0, 1, 1, 1, 0, 0, 1};
        for (int i = 0; i < integerArray.length; i++) {
            switch (integerArray[i]) {
                case 0 -> integerArray[i] = 1;
                case 1 -> integerArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(integerArray));
    }

    //Вариант 3. Математический
    public static void invertArray3() {
        int[] integerArray = {1, 0, 1, 1, 1, 0, 0, 1};
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = Math.abs(integerArray[i] - 1);
        }
        System.out.println(Arrays.toString(integerArray));
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static int[] fillArray() {
        final int SIZE = 8;
        final int MULTIPLIER = 3;
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = i * MULTIPLIER;
        }
        return array;
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static int[] changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillDiagonal() {
        final int SIZE = 8;
        int[][] array = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i][i] = 1;
            array[i][SIZE - 1 - i] = 1;
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void minAndMaxElements(double[] array) {
        double min = array[0];
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        System.out.printf("Максимальный элемент массива: %.2f%n", max);
        System.out.printf("Минимальный элемент массива: %.2f%n", min);
    }

    /*
    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     граница показана символами ||, эти символы в массив не входят.
    */

    /*Из различных вариантов решения я выбрал следующую логику:
    Если в массиве есть баланс, то значит есть такое положение условного разделителя, при которой сумма элементов,
    расположенных слева от разделителя, будет равна полусумме всех элементов. Считаю решение более рациональным,
    чем если бы устанавливать разделитель, а потом сравнивать суммы элементов слева и справа от него.
    При таком решение получилось бы два цикла со сложными условиями, вложенные в другой цикл */
    public static boolean checkBalance(int[] array) {
        boolean result = false;
        double halfSum = 0; //тип double необходим, чтобы не потерять дробную часть при вычислении полусуммы, если полная сумма будет нечетной
        int leftSum = 0;
        for (int a : array) halfSum += a;
        halfSum /= 2;
        for (int a : array) {
            leftSum += a;
            if (leftSum == halfSum) result = true;
        }
        return result;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив
    // и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы
    // массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static int[] shiftArray(int[] array, int n) {
        if (n > 0) {                                                //обрабатываем сдвиг вправо
            for (int count = 0; count < Math.abs(n); count++) {
                int a = array[0];
                for (int i = 0; i < array.length - 1; i++)
                    array[i] = array[i + 1];
                array[array.length - 1] = a;
            }
        } else if (n < 0) {                                           //обрабатываем сдвиг слево
            for (int count = 0; count < Math.abs(n); count++) {
                int a = array[array.length - 1];
                for (int i = array.length - 1; i > 0; i--)
                    array[i] = array[i - 1];
                array[0] = a;
            }
        }
        return array;
    }
}
