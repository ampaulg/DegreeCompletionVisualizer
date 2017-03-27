package ca.cmpt213.as4.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Gill on 2017-03-21.
 */
public class Student implements Comparable<Student>{

    private int studentNumber;
    private char gender;
    private int levelCompleted = 0;


    //private boolean transferred;
    private boolean graduated;
    private List<ProgramAction> actions = new ArrayList<>();
    private List<Semester> semesters = new ArrayList<>();

    public Student(String[] line){
        studentNumber = Integer.parseInt(line[0]);
        gender = (char) line[1].charAt(0);
    }

    public char getGender() {
        return gender;
    }

    public boolean isGraduated(){
        return graduated;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public List<Semester> getSemesters(){
        return semesters;
    }

    public List<ProgramAction> getActions(){
        return actions;
    }

    public void addAction(ProgramAction action){
        actions.add(action);
        if (action.getAction().equals("fin")){
            graduated = true;
        }
    }

    public void addSemester(Semester semester){
        semesters.add(semester);
        if (semester.getLevel() > levelCompleted){
            levelCompleted = semester.getLevel();
        }
    }

    @Override
    public int compareTo(Student other){
        if (other.getStudentNumber() < studentNumber){
            return 1;
        }
        else if (other.getStudentNumber() > studentNumber) {
            return -1;
        }
        else return 0;
    }
}
