package net.ukr.ahavrykin;

import Exeptions.AlreadyIncludedException;
import Exeptions.NoPlaceExseption;

import java.util.Scanner;

public class StudentInput {

    public static Student inputStudent() {
        Scanner sc = new Scanner(System.in);
        Student st = new Student();

        System.out.println("Enter student name");
        st.setName(sc.nextLine());

        System.out.println("Enter student last name");
        st.setSurname(sc.nextLine());

        System.out.println("Enter student age");
        st.setAge(sc.nextInt());

        System.out.println("Enter student sex (man or woman)");
        sc.nextLine();
        String s1 = sc.nextLine();
        if (s1.equals("man")) {
            st.setSex(Sex.MALE);
        } else if (s1.equals("woman")) {
            st.setSex(Sex.FEMALE);
        } else {
            System.out.println("wrong in");
        }
        System.out.println("Enter student id");
        st.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter student group");
        st.setGroupName(sc.nextLine());
        return st;
    }

    public static void addInputStudent(Group gr, Student st) {
        try {
            gr.addStudent(st);
        } catch (AlreadyIncludedException e) {
            System.out.println(e.getMessage());
        } catch (NoPlaceExseption e) {
            System.out.println(e.getMessage());
        }
    }
}
