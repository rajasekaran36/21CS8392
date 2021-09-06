class Key{
    private int code;
    public Key(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
class Lock{
    int keyCode = 12134;
    private boolean locked = true;
    private Key key;
    public Lock(){
        key = new Key(this.keyCode);
    }
    public void doLock(){
        this.locked = true;
    }
    public void doUnlock(Key key){
        if(key.getCode() == keyCode)
            this.locked = false;
    }
    public boolean isLocked(){
        if(locked == true){
            return true;
        }
        return false;
    }
    public Key getKey(){
        return key;
    }
}

abstract class Vehicle{
    private Lock lock;
    public Vehicle(){
        lock = new Lock();    
    }
    abstract public void start();
    public void unLock(Key key){
        lock.doUnlock(key);
    }
    public boolean isLockOpen(){
        if(!lock.isLocked())
            return true;
        else
            return false;
    }
    public Key getKey(){
        return lock.getKey();
    }
}

class Bike extends Vehicle{
    @Override
    public void start(){
        if(isLockOpen()){
            System.out.println("Please Do Kick Start");
        }
        else{
            System.out.println("Please unlock your vehicle");
        }
    }
}

public class Main {
    public static void main(String[] args) {
       //Reg
       Bike bike = new Bike();
       Key key = bike.getKey();

       //Road
       bike.unLock(key);
       bike.start();
       System.out.println("Change");
    }
}
