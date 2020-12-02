package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class XODots {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '•';
    public static Scanner in = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        turnGame();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    private static void printMap() {
        System.out.printf("%2c", DOT_EMPTY);
        for (int i = 0; i < SIZE; i++)
            System.out.printf("%2d", i + 1);
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d", i + 1);
            for (int j = 0; j < SIZE; j++)
                System.out.printf("%2c", map[j][i]);
            System.out.println();
        }
    }

    private static void turnGame() {
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, DOTS_TO_WIN)) {
                System.out.println("Вы победили! Поздравляем!");
                System.exit(0);
            }
            if (isMapFull()) System.exit(0);

            computerTurn();
            printMap();
            if (checkWin(DOT_O, DOTS_TO_WIN)) {
                System.out.println("Победил компьютер");
                System.exit(0);
            }
            if (isMapFull()) System.exit(0);
        }
    }

    private static void humanTurn() {
        int x, y;
        System.out.println("Поставьте крестик. Введите координаты в формате X Y");
        do {
            System.out.print("X: ");
            x = in.nextInt() - 1;
            System.out.print("Y: ");
            y = in.nextInt() - 1;
        } while (!checkXY(x, y));
        map[x][y] = DOT_X;
    }

    //Дополним вывод комментария о неправильных координатах
    private static boolean checkXY(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Выход за границы поля. Введите координаты в формате X Y еще раз");
            return false;
        }
        if (map[x][y] == DOT_EMPTY) return true;
        System.out.println("Клетка занята. Введите координаты другой клетки в формате X Y");
        return false;
    }

    private static void computerTurn() {
        int[] coordinates;
        coordinates = checkNextTurnToWin(DOTS_TO_WIN, DOT_O); //Проверяем возможность победить на этом ходу
        //Если на прошлой проверке не удалось найти выигрышную позицию, выполняем поиск хода для "перехвата" игрока
        if (coordinates[0] == -1)
            for (int numberOfIdenticalCells = 2; numberOfIdenticalCells <= DOTS_TO_WIN; numberOfIdenticalCells++)
                coordinates = checkNextTurnToWin(numberOfIdenticalCells, DOT_X);
        //Таким образом мы найдем ту клетку, которая даст наибольшую вероятность победы для человека.
        //Если же и таких позиций не выявлено, то компьютер ходит случайно
        if (coordinates[0] == -1) {
            do {
                coordinates[0] = rand.nextInt(SIZE);
                coordinates[1] = rand.nextInt(SIZE);
            } while (map[coordinates[0]][coordinates[1]] != DOT_EMPTY);
        }
        map[coordinates[0]][coordinates[1]] = DOT_O;
        System.out.println("Компьютер походил в клетку " + (coordinates[0] + 1) + " " + (coordinates[1] + 1));
    }

    //Перебираем массив на возможность выигрышной или предвыигрышной ситуации. Если выигрышная ситуация возможна, то
    //метод возвращает координаты клетки, куда необходимо сделать ход. Если таких клеток нет, возвращаются {-1, -1}
    private static int[] checkNextTurnToWin(int numberOfIdenticalCells, char symbol) {
        int[] coordinates = {-1, -1};
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = symbol; //временно подставляем крестик в пустую клетку
                    // проверяем на выигрыш получившуюся ситуацию, т.е. наличие подряд идущих numberOfIdenticalCells клеток
                    if (checkWin(symbol, numberOfIdenticalCells)) {
                        coordinates[0] = i;
                        coordinates[1] = j;
                    }
                    map[i][j] = DOT_EMPTY; //возвращаем пустую клетку на место
                }
            }
        return coordinates;
    }

    private static boolean checkWin(char symbol, int numberOfIdenticalCells) {
        //проверка выигрыша сводится к подсчету повторяющихся подряд идущих символов в строке, столбце и диагоналях
        //условие проверки: текущая и следующая(предыдущая) клетки совпадают И текущая соответствует символу на входе метода
        //Если цепочка совпадений заканчивается до достижения заданного числа, счетчик обнуляется
        int count = 0; //счетчик совпадений
        //проверка горизонталей
        for (int j = 0; j < SIZE; j++) {
            for (int i = 1; i < SIZE; i++) {
                if (map[i][j] == map[i - 1][j] & map[i][j] == symbol) count++;
                else count = 0;
                if (count == numberOfIdenticalCells - 1) return true;
            }
            count = 0; //каждый раз обнуляем, если не нашли нужной игровой ситуации
        }
        //проверка вертикалей
        for (int i = 0; i < SIZE; i++) {
            for (int j = 1; j < SIZE; j++) {
                if (map[i][j] == map[i][j - 1] & map[i][j] == symbol) count++;
                else count = 0;
                if (count == numberOfIdenticalCells - 1) return true;
            }
            count = 0;
        }
        //проверка диагоналей
        for (int i = 0; i < SIZE; i++) {
            //диагонали параллельные главной и выше нее
            for (int j = 0; j < SIZE - i - 1; j++) {
                if (map[i + j][j] == map[i + j + 1][j + 1] & map[i + j][j] == symbol) count++;
                else count = 0;
                if (count == numberOfIdenticalCells - 1) return true;
            }
            count = 0;
            //диагонали, параллельные побочной и выше нее
            for (int j = 0; j < i; j++) {
                if (map[i - j][j] == map[i - j - 1][j + 1] & map[i - j][j] == symbol) count++;
                else count = 0;
                if (count == numberOfIdenticalCells - 1) return true;
            }
            count = 0;
            //диагонали, параллельные побочной и ниже нее
            for (int j = 0; j < SIZE - i - 1; j++) {
                if (map[i + j][SIZE - j - 1] == map[i + j + 1][SIZE - j - 2] & map[i + j][SIZE - j - 1] == symbol)
                    count++;
                else count = 0;
                if (count == numberOfIdenticalCells - 1) return true;
            }
            count = 0;
            //диагонали, параллельные главной и ниже нее
            for (int j = 0; j < i; j++) {
                if (map[i - j][SIZE - j - 1] == map[i - j - 1][SIZE - j - 2] & map[i - j][SIZE - j - 1] == symbol)
                    count++;
                else count = 0;
                if (count == numberOfIdenticalCells - 1) return true;
            }
            count = 0;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        System.out.println("Свободных клеток не осталось. Ничья!");
        return true;
    }

}
