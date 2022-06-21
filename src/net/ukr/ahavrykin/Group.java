package net.ukr.ahavrykin;

import Exeptions.AlreadyIncludedException;
import Exeptions.NoPlaceExseption;
import Exeptions.NoStudentInGroupExseption;

import java.util.Arrays;


public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(String groupName, Student[] students) {
        this.groupName = groupName;
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addStudent(Student st) throws NoPlaceExseption, AlreadyIncludedException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                st.setGroupName(this.groupName);
                students[i] = st;
                return;
            } else if (students[i].getName()==st.getName()&&students[i].getSurname() == st.getSurname()) {
                System.out.print(students[i].getName() + " " + students[i].getSurname() + " - ");
                throw new AlreadyIncludedException();
            }
        }
        throw new NoPlaceExseption();
    }

    public void deleteStudent(int id) throws NoStudentInGroupExseption {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId() == id) {
                students[i] = null;
            }
        }throw new NoStudentInGroupExseption();
    }

    public Student searchStudent(String surname) throws NoStudentInGroupExseption {
        System.out.println(surname);
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getSurname() == surname) {
                return students[i];
            }
        }
        throw new NoStudentInGroupExseption();
    }

    public String toString1() {
        Student tempValue;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i; j < students.length - 1; j++) {
                if (students[j] == null) {
                    tempValue = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = tempValue;
                }
            }
        }
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i; j < students.length - 1; j++) {
                if (students[j + 1] == null) {
                    break;
                } else if (students[i].getSurname().compareTo(students[j + 1].getSurname()) > 0) {
                    tempValue = students[i];
                    students[i] = students[j + 1];
                    students[j + 1] = tempValue;
                }
            }
        }
        return "Group [students=" + Arrays.toString(students) + ", groupname=" + groupName + "]";
    }

    private String makeList(Student[] arr) {
        String list = "";
        for (Student el : arr) {
            if (el == null)
                continue;

            list += "Group " + el.getGroupName() + "[" + el.getName() + " " + el.getSurname() + " (" + el.getId()
                    + ") , " + el.getAge() + ", " + el.getSex() + "," + "]" + "\n";
        }
        return list;
    }

    @Override
    public String toString() {
        return makeList(students);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!groupName.equals(group.groupName)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        int result = groupName.hashCode();
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }
}
