package ma.mtm.service;

import ma.mtm.classes.Student;

public class main {
    public static void main(String[] args) {
        StudentService stdserv = new StudentService();

        System.out.println(stdserv.findAll());
    }
}
