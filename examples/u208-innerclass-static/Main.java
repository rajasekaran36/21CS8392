class Outer{
    int outVar = 100;
    public void displayOutVar(){
        System.out.println("outVar="+outVar);
    }
    public void setOutVar(int value){
        this.outVar = value;

    }
    static class Inner{
        int inVar = 2000;
        void displayInVar(){
            System.out.println("inVar="+inVar);
        }
        void setInVar(int value){
            this.inVar = value;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = new Outer.Inner();
        outer.displayOutVar();
        inner.displayInVar();
    }
}
