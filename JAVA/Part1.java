/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/


import java.util.ArrayList;


public class Part1 {
    public static void main(String[] args) {
        // Test for Homework 2 Part 1
        ArrayList<Student> students = new ArrayList<Student>();
        
        Student st0 = new FinanciallyAssistedStudent(123456, "bob0", "smith0", 32, 11, "beverage Engineering", "Good", 500);
        Student st1 = new NonFinanciallyAssistedStudent(456123, "bob1", "smith1", 30, 12, "beverage Engineering", "Good");
        Student st2 = new CertificateStudent(123789, "bob2", "smith2", 48, 9, "gaming Science");
        Student st3 = new SeniorCitizenStudent(456789, "bob3", "smith3", 68, 3);


        students.add(st0);
        students.add(st1);
        students.add(st2);
        students.add(st3);

        System.out.println("");
        for (Student student : students) {
            student.printData();
            System.out.println(student.getFirstName() + " has a fee of $" + student.computeFees());
            System.out.println("==================================================================================");
        }
        System.out.println("");
    }
}
 