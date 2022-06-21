package net.ukr.ahavrykin;

import java.util.Comparator;

public class StudentSurnameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Student st1 = (Student) o1;
        Student st2 = (Student) o2;
        String surname1 = st1.getSurname();
        String surname2 = st2.getSurname();

        if (surname1.compareTo(surname2) > 0) {
            return 1;
        }

        if (surname1.compareTo(surname2) < 0) {
            return -1;
        }
        return 0;
    }
}
