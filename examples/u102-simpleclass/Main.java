class Vehicle{
    
    String model;
    String ownerName;
    int maxSpeed;
    boolean engineOn = false;
    int currentSpeed = 0;
    

    Vehicle(String model,String ownerName,int maxSpeed){
        this.model = model;
        this.ownerName = ownerName;
        this.maxSpeed = maxSpeed;
    }

    void start(){
        engineOn = true;
        System.out.println("Engine ON");
    }

    void accelerate(){
        currentSpeed = currentSpeed + 10;
        System.out.println("Vehicle Accelerated to "+currentSpeed+" km/hr");
    }

    void breaking(){
        currentSpeed = currentSpeed - 5;
        System.out.println("Vehicle Deaccelerated to "+currentSpeed+" km/hr");
    }

    void stop(){
        currentSpeed = 0;
        engineOn = false;
        System.out.println("Engine OFF");
    }

    void displayInfo(){
        System.out.println("\n\nMODEL:"+model);
        System.out.println("OWNER:"+ownerName);
        System.out.println("MAX SPEED:"+maxSpeed);
    }

    void getStatus(){
        if(engineOn){
            System.out.println("ENGINE ON");
        }
        else{
            System.out.println("ENGINE OFF");
        }
        System.out.println("Current Speed: "+currentSpeed+" km/hr");
    }

}

class Main{
    
    public static void main(String[] args){
        Vehicle v1 = new Vehicle("Swift", "Rajasekaran", 240);
        v1.displayInfo();

        Vehicle v2 = new Vehicle("Wangon R", "Sathish R", 180);
        v2.displayInfo();
    }

}