package lesson6;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void plateInfo() {
        System.out.println("Еды в тарелке: " + this.food);
    }

    public boolean decreaseFood(int quantity) {
        if (this.food - quantity >= 0) {
            this.food = this.food - quantity;
            return true;
        }
        return false;
    }

    public void increaseFood(int food) {
        this.food += food;
    }
}
