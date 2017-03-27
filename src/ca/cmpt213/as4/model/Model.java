package ca.cmpt213.as4.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Gill on 2017-03-23.
 */
public class Model {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        //File f = new File("data/1-SingleDirectAdmit/test_students.csv");
        File f = new File("data/8-BigSet/test_students.csv");
        try {
            Scanner s = new Scanner(f);
            s.nextLine();
            while (s.hasNextLine()){
                parseStudent(s.nextLine(), students);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        Collections.sort(students);

        //f = new File("data/1-SingleDirectAdmit/test_semesters.csv");
        f = new File("data/8-BigSet/test_semesters.csv");
        try {
            Scanner s = new Scanner(f);
            s.nextLine();
            while (s.hasNextLine()){
                parseSemesters(s.nextLine(), students);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        //f = new File("data/1-SingleDirectAdmit/test_programs.csv");
        f = new File("data/8-BigSet/test_programs.csv");
        try {
            Scanner s = new Scanner(f);
            s.nextLine();
            while (s.hasNextLine()){
                parseActions(s.nextLine(), students);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        //testActions(students);
        //testSemesters(students);
        //System.out.println(students.size());
        printStudentInfo(students);
        //searchTest(students);
    }

    private static void parseStudent(String line, List<Student> students){
        String[] line2 = line.split(", ");
        students.add(new Student(line2));
    }

    private static void parseSemesters(String line, List<Student> students){
        String[] line2 = line.split(",");
        Student s = getStudentByNumber(students, Integer.parseInt(line2[0]));
        s.addSemester(new Semester(line2));
    }

    private static void parseActions(String line, List<Student> students){
        String[] line2 = line.split(",");
        Student s = getStudentByNumber(students, Integer.parseInt(line2[0]));
        s.addAction(new ProgramAction(line2));
    }

    private static void testActions(List<Student> students){
        for (Student s : students){
            if (s.getActions().size() > 0){
                System.out.println("Student " + s.getStudentNumber() + " has done " + s.getActions().size() + " actions");
            }
        }
    }

    private static void testSemesters(List<Student> students){
        for (Student s : students){
            if (s.getSemesters().size() > 0){
                System.out.println("Student " + s.getStudentNumber() + " has enrolled in " + s.getSemesters().size() + " semesters");
            }
        }
    }

    private static void searchTest(List<Student> students){
        System.out.println("Student 386689983, M is " + getStudentByNumber(students, 386689983).getGender()); //M
        System.out.println("Student 334585094, F is " + getStudentByNumber(students, 334585094).getGender()); //F
        System.out.println("Student 344457608, M is " + getStudentByNumber(students, 344457608).getGender()); //M
        System.out.println("Student 325468878, F is " + getStudentByNumber(students, 325468878).getGender()); //F
        System.out.println("Student 322944443, M is " + getStudentByNumber(students, 322944443).getGender()); //M
    }

    private static Student getStudentByNumber(List<Student> students, int number){
        for (Student s: students){
            if (s.getStudentNumber() == number){
                return s;
            }
        }
        return null;
    }

    public static void printStudentInfo(List<Student> students){

        int male = 0;
        int female = 0;
        int unknown = 0;
        int csmaj = 0;
        int grad = 0;
        int dropouts = 0;

        for (Student s: students){
            char gender = s.getGender();
            switch (gender){
                case 'M': male++;
                          break;
                case 'F': female++;
                    break;
                case 'U': unknown++;
                    break;
            }
            if (s.isGraduated()){
                grad++;
            }
            if (s.getActions().size() > 0){
                if (s.getActions().get((s.getActions().size() - 1)).getMajor().equals("CSMAJ")){
                    csmaj++;
                }
                else if (s.getActions().get((s.getActions().size() - 1)).getAction().equals("dropout")){
                    dropouts++;
                }
            }
            //System.out.println("Student number is " + s.getStudentNumber() +", gender " + s.getGender());
        }
        System.out.println("Males: " + male);
        System.out.println("Females: " + female);
        System.out.println("Unknown: " + unknown);
        System.out.println("CS Majors: " + csmaj);
        System.out.println("Graduates: " + grad);
        System.out.println("Dropouts: " + dropouts);
    }

}
