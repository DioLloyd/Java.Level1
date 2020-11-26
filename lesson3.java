package ru.geekbrains.lesson3;


import java.util.Scanner;

public class lesson3 {
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        String word = random();
        System.out.println(word);
        System.out.println("Угадай продукт:");

        Scanner scannerWord = new Scanner(System.in);
        String inputWord = scannerWord.nextLine();

        while (!inputWord.equals(word)){
            wrongAnswer(word, inputWord);
            System.out.println("Попробуйте ещё:");
            inputWord = scannerWord.nextLine();
        }
        System.out.println("Правильно! Вы выиграли!");
    }

    private static void wrongAnswer(String word, String inputWord) {
        int minVal = Math.min(word.length(), inputWord.length());
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < minVal; i++) {
            char a = word.charAt(i);
            char b = inputWord.charAt(i);
            if (a == b) {
                c.append(a);
            } else {
                c.append("#");
            }
        }
        for (int j = 0; j < (15 - minVal); j++) {
            c.append("#");
        }
        System.out.println(c);
    }

    public static String random() {
        int rand = (int) (Math.random() * words.length);
        return words[rand];
    }

}
