/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/


public final class SeniorCitizenStudent extends NonDegreeSeekingStudent {

    public SeniorCitizenStudent(int id, String fn, String ln, int old, int hours) {
        super(id, fn, ln, old, hours);
    }

    @Override
    public void printData() {
        System.out.println(String.format("%-11s","ID number: ") + Integer.toString(super.getSid()));
        System.out.println(String.format("%-11s","Name: ") + super.getFirstName() + " " + super.getLastName());
        System.out.println(String.format("%-11s","Age: ") + Integer.toString(super.getAge()));
        System.out.println("");
        System.out.println(super.getFirstName() + " is a nondegree-seeking student enrolled in " + Integer.toString(super.getCreditHours()) + " credits");
    }

    @Override
    public double computeFees() {
        if (getCreditHours() < 7) {
            return 100.00;
        }
        double answer = 100 + (50 * (getCreditHours() - 6));
        
        if (answer < 0) {
            return 0;
        } else {
            return answer;
        }
    }
}
