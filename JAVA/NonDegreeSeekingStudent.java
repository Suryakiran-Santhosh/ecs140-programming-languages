/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/

abstract class NonDegreeSeekingStudent extends Student {

    public NonDegreeSeekingStudent(int id, String fn, String ln, int old, int hours) {
        super(id, fn, ln, old, hours);
    }

    // abstract methods
    // in the case of future implementation
    public void printData() {  
        System.out.println(String.format("%-11s","ID number: ") + Integer.toString(super.getSid()));
        System.out.println(String.format("%-11s","Name: ") + super.getFirstName() + " " + super.getLastName());
        System.out.println(String.format("%-11s","Age: ") + Integer.toString(super.getAge()));
        System.out.println("");
        System.out.println(super.getFirstName() + " is a nondegree-seeking student enrolled in " + Integer.toString(super.getCreditHours()) + " credits");
    }

    public abstract double computeFees();
    
}
