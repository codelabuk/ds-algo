package org.example1.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapListProblem {


    public static void main(String[] args) {

        List<String> listOfStrings1 = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> entry = listOfStrings1.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> Collections.singletonMap(e.getKey(), e.getValue()))
                .orElse(Collections.emptyMap());

        System.out.println(entry);

    }



}

