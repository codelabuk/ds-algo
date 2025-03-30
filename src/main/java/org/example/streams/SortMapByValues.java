package org.example.streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortMapByValues {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("banana",2);
        map.put("apple", 1);
        map.put("cherry", 3);

        Map<String,Integer> sortedMap1 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);

        System.out.println(sortedMap1);
    }
}
