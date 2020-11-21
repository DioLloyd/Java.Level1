package lesson6;

public class Cat extends Animal {

    public Cat(String name, int runLimit, float jumpLimit) {
        super(name, runLimit, jumpLimit, 0);
    }

    @Override
    public String getName() {
        return "Кот " + super.getName();
    }

}
