/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/

public final class CertificateStudent extends NonDegreeSeekingStudent {

    private String major = "";

    public CertificateStudent(int id, String fn, String ln, int old, int hours, String inputMajor) {
        super(id, fn, ln, old, hours);
        setMajor(inputMajor);
    }

    // mutator functions
    public void setMajor(String inputMajor) {
        major = inputMajor.toLowerCase();
    }

    // accessor functions
    public String getMajor() {
        return major;
    }
    
    @Override
    public void printData() {
        System.out.println(String.format("%-11s","ID number: ") + Integer.toString(super.getSid()));
        System.out.println(String.format("%-11s","Name: ") + super.getFirstName() + " " + super.getLastName());
        System.out.println(String.format("%-11s","Age: ") + Integer.toString(super.getAge()));
        System.out.println("");
        System.out.println(super.getFirstName() + " is a nondegree-seeking student enrolled in " + Integer.toString(super.getCreditHours()) + " credits");
        System.out.println(super.getFirstName() + "'s is pursing a vocational credentials in " + getMajor());
    }

    @Override
    public double computeFees() {
        double answer = 700 + (300 * getCreditHours());
        if (answer < 0) {
            return 0;
        } else {
            return answer;
        }
    }
}
