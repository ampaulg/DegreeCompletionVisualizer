package ca.cmpt213.as4.model;

/**
 * An entry consisting of what happened to the student's program
 * ie. which one, and did they add/drop/grad/etc.
 */
public class ProgramAction {

    private String action;
    private String major;
    private int semesterCode;


    public ProgramAction(String[] line){
        semesterCode = Integer.parseInt(line[1]);
        action = (line[2]);
        if (!action.equals("dropout")){
            major = line[3];
        }
        else{
            major = "NA";
        }
    }

    public String getAction() {
        return action;
    }

    public String getMajor() {
        return major;
    }

    public int getSemesterCode() {
        return semesterCode;
    }
}
