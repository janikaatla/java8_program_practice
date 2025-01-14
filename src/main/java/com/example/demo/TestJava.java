package com.example.demo;

import org.apache.catalina.util.StringUtil;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TestJava {

    public static void main(String[] arg) {
        /*
        1.Write Java program that checks if two arrays contain the same elements.
2.Write a Java program that sorts HashMap by value.

3.Write a Java program to check if a vowel is present in a string.
aeiou
         */

        int[] ar1= {1,3,4,5,2};
        int[] ar2= {1,3,4,5,2,1};

        Map<Integer, Long> firstArray=Arrays.stream(ar1).sorted().mapToObj(e->(Integer)e)
                .collect(Collectors.groupingBy(e->e, Collectors.counting()));
        Map<Integer, Long> secondArray=Arrays.stream(ar2).sorted().mapToObj(e->(Integer)e)
                .collect(Collectors.groupingBy(e->e, Collectors.counting()));
        System.out.println(firstArray.equals(secondArray));
        System.out.println(secondArray.entrySet().retainAll(firstArray.entrySet()));
        boolean ss=false;
        for (Map.Entry<Integer, Long> entry:firstArray.entrySet()) {
            if (secondArray.get(entry.getKey()) == null) {
                ss=false;
                break;
            } else {
                if (!secondArray.get(entry.getKey()).equals(entry.getValue())) {
                    ss=false;
                    break;
                }
                ss=true;
            }

        }

        if (!ss) {
            System.out.println("Not Matched All elements");
        } else {
            System.out.println("Matched All elements");
        }

        Optional<Boolean> b= Optional.of(firstArray.entrySet().stream()

                .filter(m -> (secondArray.get(m.getKey()) == null || secondArray.get(m.getKey()) != null
                        && !secondArray.get(m.getKey()).equals(m.getValue()))).findFirst().isPresent());


        int[] ar3= {1,3,4,5,2,1,2,3,4,5};
        Map<Integer, Integer> h=new HashMap<>();
        h.put(1,3);
        h.put(2,1);
        h.put(4,2);
        h.put(3,4);
        LinkedHashMap<Integer, Integer> res=h.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(e-> e.getKey(), e->e.getValue(),
                                (o,n) -> o,LinkedHashMap::new));

        System.out.println(res);

        String s="Test the vowel";
        String vowel="aeiou";

        Optional<Boolean> ch= Optional.of(s.chars().mapToObj(c -> String.valueOf((char) c))
                        //.peek(System.out::println)
                .filter(c -> vowel.contains(c.toLowerCase()))
                .peek(System.out::println)
                .findFirst().isPresent());

        System.out.println(ch.isPresent());


    }
}
