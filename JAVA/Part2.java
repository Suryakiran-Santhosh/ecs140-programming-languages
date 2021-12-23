/*
ECS 140A: Summer Session 1
Homework Assignment 2
By: Suryakiran Santhosh 
University of California, Davis
*/


import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/*
Approach to solving this problem:
1.) open file 
2.) read each line of the file
3.) split line by ";"
4.) create Student object
5.) print Student objects and their computeFee
*/


public class Part2 {
    public static void main(String[] args) {
        // Test for Homework 2 Part 2 
        ArrayList<Student> students = new ArrayList<Student>(100);

        String fileName = "hw2.txt";
        for (ArrayList<String> student : parseInput(fileName)) {
            students.add(createStudent(student));
        }

        System.out.println("==================================================================================");
        System.out.println("HOMEWORK2: Part 2");
        System.out.println("Report 1: Printing out all the students from the file.");
        System.out.println("==================================================================================");
        
        // print out information database
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " has a fee of $" + student.computeFees());
        }

        System.out.println("");
        System.out.println("");
        System.out.println("==================================================================================");
        System.out.println("HOMEWORK2: Part 2");
        System.out.println("Report 2: Summary of the amount of money the university has assessed.");
        System.out.println("==================================================================================");
        secondReport(students);
    }


    private static void secondReport(ArrayList<Student> db) {
        double noFinAid = noFinTotalFees(db);
        double finAid = finTotalFees(db);
        double certFees = certTotalFees(db);
        double seniorFees = seniorTotalFees(db);
        double total = noFinAid + finAid + certFees + seniorFees;

        System.out.println("Degree-seeking students without financial assitance: $" + noFinAid);
        System.out.println("Degree-seeking students with financial assitance: $" + finAid);
        System.out.println("Cretificate students: $" + certFees);
        System.out.println("Senior Citizens: $" + seniorFees);

        System.out.println("");

        System.out.println("Total fees assessed: $" + total);
    }

    private static double noFinTotalFees(ArrayList<Student> db) {
        double runningSum = 0;
        for (Student student : db) {
            if (student instanceof NonFinanciallyAssistedStudent) {
                runningSum += student.computeFees();
            }
        }
        return runningSum;
    }
    
    private static double finTotalFees(ArrayList<Student> db) {
        double runningSum = 0;
        for (Student student : db) {
            if (student instanceof FinanciallyAssistedStudent) {
                runningSum += student.computeFees();
            }
        }
        return runningSum;
    }

    private static double certTotalFees(ArrayList<Student> db) {
        double runningSum = 0;
        for (Student student : db) {
            if (student instanceof CertificateStudent) {
                runningSum += student.computeFees();
            }
        }
        return runningSum;
    }

    private static double seniorTotalFees(ArrayList<Student> db) {
        double runningSum = 0;
        for (Student student : db) {
            if (student instanceof SeniorCitizenStudent) {
                runningSum += student.computeFees();
            }
        }
        return runningSum;
    }
    
    private static ArrayList<ArrayList<String>> parseInput(String fileName) {
        ArrayList<String> lines = new ArrayList<String>();

        // open and read from file line by line
        try {
            File file = new File(fileName);  // open file
            Scanner fileReader = new Scanner(file);  // object that reads from file  
            while (fileReader.hasNextLine()) {  // read and print out line
                String fileLine = fileReader.nextLine();
                if (fileLine.length() > 2) {
                    lines.add(fileLine); 
                }
        
                if (lines.size() == 100) {
                    fileReader.close();
                    throw new IndexOutOfBoundsException("The database array has 100 students. No more can be accepted at this time");
                }
            }
            fileReader.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error occured when attempting to open file: " + fileName);
        }

        // process each line and create an output
        ArrayList<ArrayList<String>> studentInformation = new ArrayList<ArrayList<String>>(); 
        for (String line: lines) {
            studentInformation.add(parseLine(line));
        }
        
        return studentInformation;
    }


    private static ArrayList<String> parseLine(String line) {  // parse line
        ArrayList<String> studentInformation = new ArrayList<String>();
        String[] stringArray = line.split(";"); // split string by ;
        for (String element :stringArray) {
            studentInformation.add(element);
        }
        return studentInformation;
    }


    private static Student createStudent(ArrayList<String> info) {
        if (info.size() == 10 && info.get(8).toLowerCase().equals("y")) {  // Degree Seeking Student w/ Financial Assistance
            Student student = new FinanciallyAssistedStudent(
                Integer.parseInt(info.get(0)),  // student id
                info.get(1),  // first name
                info.get(2),  // last name
                Integer.parseInt(info.get(3)),  // age
                Integer.parseInt(info.get(4)),  // credit hours per term 
                formatMajor(info.get(6)),  // major 
                formatAcademicStanding(info.get(7)),  // academic standing 
                Double.parseDouble(info.get(9))  // financial aid amount  
            );
            return student;
        } else if (info.size() == 9 && info.get(8).toLowerCase().equals("n")) {  // Degree Seeking Student w/o Financial Assistance
            Student student = new NonFinanciallyAssistedStudent(
                Integer.parseInt(info.get(0)),  // student id
                info.get(1),  // first name
                info.get(2),  // last name
                Integer.parseInt(info.get(3)),  // age
                Integer.parseInt(info.get(4)),  // credit hours per term 
                formatMajor(info.get(6)),  // major 
                formatAcademicStanding(info.get(7))  // academic standing   
            );
            return student;
        } else if (info.size() == 8 && info.get(5).toLowerCase().equals("n") && info.get(6).toLowerCase().equals("c")) {  // NonDegree Seeking Student pursing a certificate
            Student student = new CertificateStudent(
                Integer.parseInt(info.get(0)),  // student id
                info.get(1),  // first name
                info.get(2),  // last name
                Integer.parseInt(info.get(3)),  // age
                Integer.parseInt(info.get(4)),  // credit hours per term
                formatMajor(info.get(7))  // certifate major
            );
            return student;
        } else if (info.size() == 7 && info.get(5).toLowerCase().equals("n") && info.get(6).toLowerCase().equals("s")) {  // NonDegree Seeking Senior Citizen Student
            Student student = new SeniorCitizenStudent(
                Integer.parseInt(info.get(0)),  // student id
                info.get(1),  // first name
                info.get(2),  // last name
                Integer.parseInt(info.get(3)),  // age
                Integer.parseInt(info.get(4))  // credit hours
            );
            return student;
        } else {
            throw new IllegalArgumentException("Input is not properly formatted.");
        }
    }


    private static String formatMajor(String letter) {
        String output = "";
        if (letter.equals("S")) {
            output = "Gaming Science";
        } else if (letter.equals("M")) {
            output = "Hotel Management";
        } else if (letter.equals("A")) {
            output = "Lounge Arts";
        } else if (letter.equals("E")) {
            output = "Beverage Engineering";
        }
        return output;
    }


    private static String formatAcademicStanding(String letter) {
        String output = "";
        if (letter.equals("G")) {
            output = "Good";
        } else if (letter.equals("W")) {
            output = "Warning";
        } else if (letter.equals("P")) {
            output = "Probation";
        }
        return output;
    }
}
