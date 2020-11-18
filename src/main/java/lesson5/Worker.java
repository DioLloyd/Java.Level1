package lesson5;

public class Worker {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    private int soulAge;

    public Worker(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.soulAge = age;
    }

    public void infoWorker() {
        System.out.printf(
                "Name: %s\nPosition: %s\nEmail: %s\nPhone: %s\nSalary: %d\nAge: %d\nSoulAge: %d%n",
                name, position, email, phone, salary, age, soulAge);
        System.out.println();
    }

    public int getAge() {
        return age;
    }

    public void setSoulAge(int soulAge) {
        this.soulAge = soulAge;
    }
}
