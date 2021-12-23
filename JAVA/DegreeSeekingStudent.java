/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/

abstract class DegreeSeekingStudent extends Student {
    // attributes
    private String major = "";  // gaming science; hotel management; lounge arts; beverage engineering
    private String academicStanding = "";  // good; warning; probation


    // constructor
    public DegreeSeekingStudent(int id, String fn, String ln, int old, int hours, String areaStudy, String schoolStanding) {
        super(id, fn, ln, old, hours);
        setMajor(areaStudy);
        setAcademicStanding(schoolStanding);
    }


    // mutator functions 
    public void setMajor(String input) {
        // input validation --> if input is not one of the 6 majors
        major = input.toLowerCase();
    }

    public void setAcademicStanding(String input) {
        // input validation --> if input is not one of the 3 standings
        academicStanding = input.toLowerCase();
    }

    // accessor functions
    public String getMajor() {
        return major;
    }

    public String getAcademicStanding() {
        return academicStanding;
    }

    // abstract methods
    public abstract void printData();
    public abstract double computeFees();
}
