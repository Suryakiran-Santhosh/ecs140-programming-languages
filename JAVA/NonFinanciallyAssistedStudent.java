/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/


public final class NonFinanciallyAssistedStudent extends DegreeSeekingStudent {

    // constructor
    public NonFinanciallyAssistedStudent(int id, String fname, String lname, int age, int hours, String major, String academicStanding) {
        super(id, fname, lname, age, hours, major, academicStanding);
    }


    // methods 
    @Override
    public void printData() {
        System.out.println(String.format("%-11s","ID number: ") + Integer.toString(super.getSid()));
        System.out.println(String.format("%-11s","Name: ") + super.getFirstName() + " " + super.getLastName());
        System.out.println(String.format("%-11s","Age: ") + Integer.toString(super.getAge()));
        System.out.println("");
        System.out.println(super.getFirstName() + " is a degree-seeking student enrolled in " + Integer.toString(super.getCreditHours()) + " credits");
        System.out.println(super.getFirstName() + " receives $" + 0 + " financial assistance per term");
        System.out.println(super.getFirstName() + "'s major is " + super.getMajor());
        System.out.println(super.getFirstName() + "'s academic standing is " + super.getAcademicStanding());
    }

    @Override
    public double computeFees() {
        if (super.getCreditHours() > 12) {
            return 3450.00;
        }

        double result = 100 + 50 + (275 * super.getCreditHours());
        if (result < 0) {
            return 0;
        } else {
            return result;
        }
    }
}