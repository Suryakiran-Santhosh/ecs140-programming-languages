/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/


abstract class Student {  
    // attributes
    private int sid;  // 6 digit id number
    private String firstName;
    private String  lastName;
    private int age;  // in years
    private int creditHours;


    // constructor
    public Student(int id, String fn, String ln, int old, int hours) {
        setSid(id);
        setFirstName(fn);
        setLastName(ln);
        setAge(old);
        setCreditHours(hours);
    }


    // mutator functions
    public void setSid(int id) {
        // input validation --> check to see if there are 6 digits
        sid = id;
    }

    public void setFirstName(String first) {
        // input validation --> check for empty string
        firstName = first;
    }

    public void setLastName(String last) {
        // input validation --> check for empty string
        lastName = last;
    }

    public void setAge(int num) {
        // input validation --> age is negative
        age = num;
    }

    public void setCreditHours(int num) {
        // input validation --> hours is negative
        creditHours = num;
    }


    // accessor functions 
    public int getSid() {
        return sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getCreditHours() {
        return creditHours;
    }    


    // abstract methods
    public abstract void printData();
    public abstract double computeFees();
}
