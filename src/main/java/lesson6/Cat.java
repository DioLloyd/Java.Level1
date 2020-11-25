package lesson6;

public class Cat extends Animal {

    public Cat(String name, int appetite, int runLimit, float jumpLimit) {
        super(name, appetite, runLimit, jumpLimit, 0);
    }

    @Override
    public String getName() {
        return "Кот " + super.getName();
    }

    public String getSatietyInfo() {
        return getName() + " " + super.getSatietyInfo();
    }
}
