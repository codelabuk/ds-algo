package org.example.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student implements  Comparable<Student>{
    int rollNo;
    String name;

    public Student(int rollNo, String name){
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public int compareTo(Student o) {
        return this.rollNo - o.rollNo;
    }

}

public class  StudentExample {
    public static void main(String[] args) {
        Student st1 = new Student(2, "a");
        Student st2 = new Student(1, "b");
        List<Student> stdList = Arrays.asList(st1, st2);
        Collections.sort(stdList);
        System.out.println(stdList);
    }
}
