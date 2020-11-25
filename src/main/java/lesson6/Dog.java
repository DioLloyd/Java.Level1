package lesson6;

public class Dog extends Animal {

    public Dog(String name, int appetite, int runLimit, float jumpLimit, int swimLimit) {
        super(name, appetite, runLimit, jumpLimit, swimLimit);
    }

    @Override
    public String getName() {
        return "Пёс " + super.getName();
    }

}