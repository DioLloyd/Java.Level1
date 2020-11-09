package ru.geekbrains.lesson2;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        System.out.println(task6(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
//        task7(new int[]{0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 0}, 2);
//        task7(new int[]{0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 0}, -2);
        task7(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, -2);
        task7(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 2);
    }

    private static void task1() {
        int[] task1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("task1:");
        System.out.println("Массив до:    " + Arrays.toString(task1));

        for (int i = 0; i < task1.length; i++) {
            task1[i] = task1[i] == 1 ? 0 : 1; //поменял if...else по подсказке idea на тернарный оператор, получилось короче
        }
        System.out.println("Массив после: " + Arrays.toString(task1));
    }

    private static void task2() {
        System.out.println("task2:");
        int[] task2 = new int[8];
        for (int i = 0; i < 8; i++) {
            task2[i] = i * 3;
        }
        System.out.println(Arrays.toString(task2));
    }

    public static void task3() {
        System.out.println("task3:");
        int[] task3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Массив до:    " + Arrays.toString(task3));
        for (int i = 0; i < task3.length; i++) {
            if (task3[i] < 6) {
                task3[i] = task3[i] * 2;
            }
        }
        System.out.println("Массив после: " + Arrays.toString(task3));
    }

    public static void task4() {
        int[][] task4 = new int[5][5];
        System.out.println("task4:");
        for (int i = 0; i < task4.length; i++) {
            task4[i][i] = 1;
            System.out.println(Arrays.toString(task4[i]));
        }
    }

    public static void task5() {
        System.out.println("task5:");
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        int[] task5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, -5};
        for (int el : task5) {
            if (el > maxNum) {
                maxNum = el;
            }
            if (el < minNum) {
                minNum = el;
            }
        }
        System.out.println("maxNum: " + maxNum);
        System.out.println("minNum: " + minNum);
    }

    public static boolean task6(int[] testArr) {
        int rightSum = 0;
        int leftSum = 0;
        System.out.println("task6: ");
        for (int i = 0; i < testArr.length - 1; i++) {
            rightSum = 0;
            for (int j = testArr.length - 1; j > i; j--) {
                rightSum = rightSum + testArr[j];
            }
            leftSum = leftSum + testArr[i];
            if (leftSum == rightSum) {
                System.out.println("leftSum: " + leftSum + " rightSum: " + rightSum);
                return true;
            }
        }
        System.out.println("leftSum: " + leftSum + " rightSum: " + rightSum);
        return false;
    }

    public static void task7(int[] testArr, int n) {
        System.out.println("task7: ");
        System.out.println(Arrays.toString(testArr) + "; n = " + n);
        if (n > 0) { //двигаем вправо. с конца
            for (int i = testArr.length - 1 - n; i >= 0; i--) {
                testArr[i + n] = testArr[i];
                testArr[i] = 0;
//                System.out.println(Arrays.toString(testArr));
            }
        } else if (n < 0) { //двигаем влево. с начала
            for (int i = -n; i < testArr.length; i++) {
                testArr[i + n] = testArr[i];
                testArr[i] = 0;
//                System.out.println(Arrays.toString(testArr));
            }
        }
        System.out.println(Arrays.toString(testArr));
    }
    //брать элементы массива и прибавлять к ним 2.
    //если индекс больше длины массива, то пропустить.
    //идти с конца если двигаешь в плюс
}
