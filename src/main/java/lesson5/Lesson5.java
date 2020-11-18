package lesson5;

public class Lesson5 {
    public static void main(String[] args) {
        Worker[] workerArray = new Worker[]{
                new Worker(
                        "Yahont L'vovich",
                        "slave",
                        "slave.yahont@email.com",
                        "88005553535",
                        4300,
                        25),
                new Worker(
                        "Karl Karlovich",
                        "manager",
                        "manager.karl@email.com",
                        "+79991234567",
                        5750,
                        30),
                new Worker(
                        "Ivan Ivanov",
                        "worker",
                        "worker.ivan@email.com",
                        "+78319995511 add 9",
                        5000,
                        40),
                new Worker(
                        "Andrey Durenko",
                        "worker",
                        "worker.andrey@email.com",
                        "+78319995511 add 6",
                        5000,
                        42),
                new Worker(
                        "Mitya Vasil'ev",
                        "worker",
                        "worker.ivan@email.com",
                        "+78319995511 add 4",
                        5000,
                        43)
        };

        workerArray[4].setSoulAge(23);

        for (Worker worker : workerArray) {
            if (worker.getAge() > 40) {
                worker.infoWorker();
            }
        }

    }

}
