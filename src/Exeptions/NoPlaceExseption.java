package Exeptions;

public class NoPlaceExseption extends Exception {

    @Override
    public String getMessage() {
        return "Student has already been in the group!";
    }
}
