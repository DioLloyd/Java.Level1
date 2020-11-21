package lesson6;

abstract class Animal {
    private final int runLimit;
    private final float jumpLimit;
    private final int swimLimit;
    private final String name;

    public String getName() {
        return name;
    }

    public Animal(String name, int runLimit, float jumpLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
    }

    public boolean run(int lenght) {
        return runLimit >= lenght;
    }

    public boolean jump(double height) {
        return jumpLimit >= height;
    }

    public boolean swim(int lenght) {
        return swimLimit >= lenght;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
