class Outer{
    int outVar = 100;
    public void displayOutVar(){
        System.out.println("outVar="+outVar);
    }
}
public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.displayOutVar();

        Outer anomInner = new Outer(){
            @Override
            public void displayOutVar(){
                System.out.println("outVar="+outVar+1000);
            }
        };
        anomInner.displayOutVar();
    }
}
