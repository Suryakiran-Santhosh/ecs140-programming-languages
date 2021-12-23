/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/


public final class FinanciallyAssistedStudent extends DegreeSeekingStudent {
    // attributes
    private double financialAssitancePerTerm;  // dollar value

    
    // constructor 
    public FinanciallyAssistedStudent(int id, String fname, String lname, int age, int hours, String major, String academicStanding, double financialAid) {
        super(id, fname, lname, age, hours, major, academicStanding);
        setFinancialAssistancePerTerm(financialAid);
    }

    // mutator functions 
    public void setFinancialAssistancePerTerm(double amount) {
        financialAssitancePerTerm = amount;
    }


    // accessor functions
    public double getFinancialAssistancePerTerm() {
        return financialAssitancePerTerm;
    }

    @Override
    public void printData() {
        System.out.println(String.format("%-11s","ID number: ") + Integer.toString(super.getSid()));
        System.out.println(String.format("%-11s","Name: ") + super.getFirstName() + " " + super.getLastName());
        System.out.println(String.format("%-11s","Age: ") + Integer.toString(super.getAge()));
        System.out.println("");
        System.out.println(super.getFirstName() + " is a degree-seeking student enrolled in " + Integer.toString(super.getCreditHours()) + " credits");
        System.out.println(super.getFirstName() + " receives $" + getFinancialAssistancePerTerm() + " financial assistance per term");
        System.out.println(super.getFirstName() + "'s major is " + super.getMajor());
        System.out.println(super.getFirstName() + "'s academic standing is " + super.getAcademicStanding());
    }

    @Override
    public double computeFees() {
        double result = 0;
        if (super.getCreditHours() > 12){
            result = 3450;
        } else {
            result = 100 + 50 + (275 * super.getCreditHours());
        }
        
        double answer = result - getFinancialAssistancePerTerm();
        if (answer < 0) {
            return 0;
        } else {
            return answer;
        }
    }
}
