package lesson6;

public class Lesson6 {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Борис", 200, 2),
                new Cat("Барсик", 300, 1.8f),
                new Dog("Бухтар", 500, 0.5f, 8),
                new Dog("Шарик", 300, 0.7f, 10)
        };

        for (Animal animal : animals) {
            animalAction(animal, 250, 1.5f, 9);
        }
    }

    public static void animalAction(Animal animal, int runAnimal, float jumpAnimal, int swimAnimal) {
        System.out.println(animal + " " + (animal.run(runAnimal) ? "может" : "не может") + " бежать " + runAnimal + " метров");
        System.out.println(animal + " " + (animal.jump(jumpAnimal) ? "может" : "не может") + " прыгнуть на " + runAnimal + " метров");
        System.out.println(animal + " " + (animal.swim(swimAnimal) ? "может" : "не может") + " плыть " + runAnimal + " метров");
        System.out.println();
    }
}

