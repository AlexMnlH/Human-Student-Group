package Exeptions;

public class NoStudentInGroupExseption extends Exception {

    @Override
    public String getMessage() {
        return "Didn`t find this student in the group!";
    }
}
