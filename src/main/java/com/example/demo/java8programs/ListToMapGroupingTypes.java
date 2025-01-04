package com.example.demo.java8programs;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapGroupingTypes {
    public static void main(String[] arg) {
        integerListToMap();
        empListToMap();
    }

    public static void integerListToMap() {
        List<Integer> integerList=List.of(1,3,2,4,1,3,4,5,2,1,4,1);
        Map<Integer, Long> mapValueCount=integerList.stream().collect(Collectors
                .groupingBy(i->i,Collectors.counting()));
        Map<Integer, Long> sortedMap = mapValueCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue)->oldValue, LinkedHashMap::new ));

        System.out.println(sortedMap);
        Map<Integer, List<Integer>> mapValues = integerList.stream().collect(Collectors.groupingBy(e -> e, Collectors.toList()));
        System.out.println(mapValues);
    }

    public static void empListToMap() {
        List<Emp> empList=List.of(new Emp("Uma", 1),new Emp("Jani", 2),
                new Emp("Jani", 1),new Emp("Vishrudh", 2),new Emp("Moksha", 2));

        Map<Integer, Long> mapEmpCount =
                empList.stream().collect(Collectors.groupingBy(Emp::getDep, Collectors.counting()));

        Map<Integer, List<Emp>> mapEmp = empList.stream().collect(Collectors.groupingBy(Emp::getDep));

        Map<Integer, List<Emp>> finalRes=mapEmp.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().stream().sorted(Comparator.comparing(Emp::getName)).toList(),(oldValue, newValue)->oldValue, LinkedHashMap::new));

        System.out.println(finalRes);
    }
}

