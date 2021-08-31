abstract class Vehicle {
    abstract public void start();
}

class Cycle extends Vehicle {
    public void start() {
        System.out.println("Unlock your Cycle");
    }
}

abstract class MotorVehicle extends Vehicle {
    public void stop() {
        System.out.println("Twist Key Anticlockwise");
    }
}

class Bike extends MotorVehicle {
    public void start() {
        System.out.println("Kick Start");
    }
}

class Car extends MotorVehicle {
    public void start() {
        System.out.println("Twist Key");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bike bike = new Bike();
        Cycle cycle = new Cycle();

        car.start();
        bike.start();
        cycle.start();
    }
}
