class Car {
    private int position;
    private int speed;

    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public int getPosition() {
        return this.position;
    }
    public int getSpeed() {
        return this.speed;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++ ) {
            cars[i] = new Car(position[i], speed[i]);
        }

        Stack<Double> stack = new Stack<>();
        Arrays.sort(cars, (a, b) -> b.position - a.position);

        for (int i = 0; i < n; i++) {
            double time = (double ) (target - cars[i].getPosition()) / cars[i].getSpeed();

             if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }
            stack.push(time);
        }
        return stack.size();
    }
}
