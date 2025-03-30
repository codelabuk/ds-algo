package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListProblem {

    public static void main(String[] args) {
        List<List<String>> names = Arrays.asList(Arrays.asList("Saket", "Trevor"), Arrays.asList("Michael"),
                Arrays.asList("Shawn", "Franklin"), Arrays.asList("Johnty", "Sean"));

       //List<String> result = names.stream().map(c-> c.stream().anyMatch((s-> s.charAt(0) == 'S'))).collect(Collectors.toList())

        List<String> result = names.stream()
                .flatMap(List::stream)
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());

        System.out.println("Result :: "+ result);

    }


}
