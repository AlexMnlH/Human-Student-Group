package net.ukr.ahavrykin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Student extends Human implements CSVConverter {
    private int id;
    private String groupName;

    public Student(String name, String surname, int age, Sex sex, int id, String groupName) {
        super(name, surname, age, sex);
        this.id = id;
        this.groupName = groupName;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student" + super.toString() + "; [id- " + id + ", groupName- " + groupName + "]";
    }

    @Override
    public String toCSVString() {
        String del = ";";
        return getName() + del + getSurname() + del + getAge() + del + getSex()
                + del + getGroupName();
    }

    @Override
    public Student fromCSVString(String s) {
        String[] arr = s.replaceAll("\\s", "").split(";");
        return new Student(arr[0], arr[1], Integer.valueOf(arr[2]),
                Sex.valueOf(arr[3]), Integer.valueOf(arr[4]), arr[5]);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return groupName.equals(student.groupName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + groupName.hashCode();
        return result;
    }
}
