package lesson6;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson6 {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Борис", 8, 200, 2),
                new Cat("Барсик", 8, 300, 1.8f),
                new Dog("Бухтар", 12, 500, 0.5f, 8),
                new Dog("Шарик", 11, 300, 0.7f, 10)
        };

        ArrayList<Cat> cats = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                cats.add((Cat) animal);
            }
        }

        Plate plate = new Plate(15);

        catsEating(cats, plate);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Пополнить тарелку? (1 - ДА, 0 - НЕТ)");
        int addFood = scanner.nextInt();
        if (addFood > 0) {
            System.out.println("Сколько еды добавить:");
            plate.increaseFood(scanner.nextInt());
            catsEating(cats, plate);
        }


//        for (Animal animal : animals) {
//            animalAction(animal, 250, 1.5f, 9);
//        }
    }

    private static void catsEating(ArrayList<Cat> cats, Plate plate) {
        plate.plateInfo();
        for (Cat cat : cats) {
            System.out.println(cat.getSatietyInfo());
            if (!cat.isSatiety()) {
                if (cat.eat(plate)) {
                    System.out.println(cat.getName() + " ест.");
                } else {
                    System.out.println("В тарелке не хватет еды.");
                }
            }
            System.out.println(cat.getSatietyInfo());
            plate.plateInfo();
        }
    }

//    public static void animalAction(Animal animal, int runAnimal, float jumpAnimal, int swimAnimal) {
//        System.out.println(animal + " " + (animal.run(runAnimal) ? "может" : "не может") + " бежать " + runAnimal + " метров");
//        System.out.println(animal + " " + (animal.jump(jumpAnimal) ? "может" : "не может") + " прыгнуть на " + runAnimal + " метров");
//        System.out.println(animal + " " + (animal.swim(swimAnimal) ? "может" : "не может") + " плыть " + runAnimal + " метров");
//        System.out.println();
//    }
}

