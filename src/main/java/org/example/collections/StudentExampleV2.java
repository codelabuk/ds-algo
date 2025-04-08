package org.example.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentV1 {
    int rollNo;
    String name;

    public StudentV1(int rollNo, String name){
        this.name = name;
        this.rollNo = rollNo;
    }


}

class NameComparator implements Comparator<StudentV1> {

    @Override
    public int compare(StudentV1 o1, StudentV1 o2) {
        return o1.rollNo - o2.rollNo;
    }
}

public class  StudentExampleV2 {
    public static void main(String[] args) {
        StudentV1 st1 = new StudentV1(2, "a");
        StudentV1 st2 = new StudentV1(1, "b");
        List<StudentV1> stdList = Arrays.asList(st1, st2);
        Collections.sort(stdList, new NameComparator());
        System.out.println(stdList);
    }
}
