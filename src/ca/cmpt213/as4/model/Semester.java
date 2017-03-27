package ca.cmpt213.as4.model;

/**
 * Created by Gill on 2017-03-23.
 */
public class Semester {

    private int semesterCode;
    private int level;

    public Semester(String[] line) {
        this.semesterCode = Integer.parseInt(line[1]);
        this.level = Integer.parseInt(line[2].substring(1,2));
    }

    public int getSemesterCode() {
        return semesterCode;
    }

    public int getLevel() {
        return level;
    }
}
