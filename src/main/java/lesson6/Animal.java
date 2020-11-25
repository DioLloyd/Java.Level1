package lesson6;

abstract class Animal {
    private final int runLimit;
    private final float jumpLimit;
    private final int swimLimit;
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Animal(String name, int appetite, int runLimit, float jumpLimit, int swimLimit) {
        this.name = name;
        this.appetite = appetite;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
        this.satiety = false;
    }

    public boolean eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            this.satiety = true;
            return true;
        }
        return false;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getSatietyInfo() {
        return isSatiety() ? "сыт." : "голоден.";
    }

//    public void setSatiety(boolean satiety) {
//        this.satiety = satiety;
//    }

    public String getName() {
        return name;
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
