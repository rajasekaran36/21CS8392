class Student {
    String name;
    String rollNo;
    String dept;

    public Student(String name, String rollNo, String dept) {
        this.name = name;
        this.rollNo = rollNo;
        this.dept = dept;
    }

    @Override
    public String toString() {
        String result = "{" + " name='" + name + "'" + " rollNo='" + rollNo + "'" + " dept='" + dept + "'" + "}";
        return result;
    }

}

/*
 * class Bike extends Vehicle{
 * 
 * }
 */
public class Main {
    public static void main(String[] args) {
        /* Vehicle v = new Bike(); */

        Object student1 = new Student("Bala", "20IT66", "IT");
        Object student2 = student1;

        // Object student2 = student1;
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        // System.out.println(student1.equals(student2));
    }
}