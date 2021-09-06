public class Main {
    final static String FINAL_VAR = "Final Val";

    static String classVar = "classVar"; // CLASS
    String instVar = "instVar"; // INSTANCE

    public static void main(String[] args) {

        int x = 10; // LOCAL

        Main m = new Main();

        System.out.println(classVar);
        System.out.println(m.instVar);
        System.out.println(Math.PI);
    }
}
