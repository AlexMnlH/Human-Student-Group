package Exeptions;

public class AlreadyIncludedException extends Exception{

    @Override
    public String getMessage() {
        return "Student had already included in the group!";
    }
}
