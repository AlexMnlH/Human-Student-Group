package net.ukr.ahavrykin;

import Exeptions.AlreadyIncludedException;
import Exeptions.NoPlaceExseption;
import Exeptions.NoStudentInGroupExseption;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) throws NoPlaceExseption, AlreadyIncludedException {
        Student student1 = new Student("Alex", "Monul", 28, Sex.MALE,
                34445082, "321");
        Student student2 = new Student("Max", "Jonson", 45, Sex.MALE,
                34344040, "322");
        Student student3 = new Student("Filip", "Jonson", 30, Sex.MALE,
                34344041, "322");
        Student student4 = new Student("Elly", "Morris", 15, Sex.FEMALE,
                34344040, "321");
        Group gr1 = new Group("321");
        try {
            gr1.addStudent(student1);
            gr1.addStudent(student2);
            gr1.addStudent(student3);
            gr1.addStudent(student4);
        } catch (AlreadyIncludedException e) {
            System.out.println(e.getMessage());
        } catch (NoPlaceExseption e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(gr1.searchStudent("Bobby"));
        } catch (NoStudentInGroupExseption e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gr1);
        try {
            gr1.deleteStudent(34445082);
        } catch (NoStudentInGroupExseption e) {
            System.out.println(e.getMessage());
        }
        Arrays.sort(gr1.getStudents(), Comparator.nullsLast(new StudentNameComparator().thenComparing(new StudentSurnameComparator())));
        System.out.println(gr1);

        //Group gr2 = new Group("322");
        //StudentInput.addInputStudent(gr2, StudentInput.inputStudent());
        //System.out.println(gr2);

        /*
        File fileSt = new File("D:\\Documents\\Studing\\Java Developer\\IdeaProjects\\Examples\\Example 03.06.22 operation with files\\testFolder\\Test.csv");
        try {
            fileSt.createNewFile();
        } catch (
                IOException e) {
            e.printStackTrace();
        }


            for (int i = 0; i < gr1.getStudents().length; i++) {
                Student.saveToCSVFile(fileSt, gr1.getStudents()[i]);
            }

         */
    }
}