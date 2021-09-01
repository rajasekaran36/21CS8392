abstract class Vehicle {
    abstract public void start();
	abstract public void stop();
}

abstract class Cycle extends Vehicle {
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
		Vehicle v = new Car();
		v.start();
		v.stop();
    }
}
