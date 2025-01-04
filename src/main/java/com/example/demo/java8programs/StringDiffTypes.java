package com.example.demo.java8programs;

import org.apache.logging.log4j.util.Supplier;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringDiffTypes {
    public static void main(String[] args) {
        //wordReverseFromStrData();
        //strReverse();
        // strToMap();
        strToRemoveDuplicateChar();

    }

    public static void strToMap() {
        String val="Find the second repeat litter from given string";
        Map<String, Long> res = Stream.of(val.split(""))
                .filter(e->!e.isBlank())
                .collect(Collectors.groupingBy(String::valueOf, LinkedHashMap::new, Collectors.counting()));
        System.out.println(res);

        res = val.chars().mapToObj(c->String.valueOf((char)c))
                .filter(e->!e.isBlank())
                .collect(Collectors.groupingBy(String::valueOf, LinkedHashMap::new, Collectors.counting()));
        System.out.println(res);

        res.entrySet().stream()
                .filter(e->e.getValue()>1)
                .skip(1).findFirst()
                .ifPresent(e->System.out.println(e.getKey()));
    }

    public static void strToRemoveDuplicateChar() {
        String val="please remove duplicate chars from given string";
        Map<String, String> removedDuplicate = Stream.of(val.split(""))
                .filter(e->!e.isBlank())
                .collect(Collectors.toMap(e->e,e->e,(old,newV)->old,LinkedHashMap::new));
        System.out.println(removedDuplicate);
        String res = String.join("", removedDuplicate.keySet());
        System.out.println(res);
    }


    public static void strReverse() {
        String name="Java Program";
        String res = name.chars()
                .mapToObj(c->String.valueOf((char)c))
                .reduce((c1,c2) -> c2+c1).orElseGet(() -> "");
        System.out.println(res);

        res = name.chars()
                .mapToObj(c->String.valueOf((char)c))
                .reduce((c1,c2) -> c2+c1).orElseGet(() -> "");
        System.out.println(res);

        res = Stream.of(name.split("\\s"))
                .map(s->new StringBuffer(s).reverse()).collect(Collectors.joining(" "));
        System.out.println(res);

        Stream.iterate(name.length()-1, n-> n >= 0, n-> n-1)
                .map(name::charAt)
                .forEach(System.out::print);

        System.out.println();

        res = Stream.of(name.split("\\s"))
                .map(w->w.chars().mapToObj(c->(char) c)
                        .map(c->c+"").reduce((c1,c2)->c2+c1).orElse(""))
                .collect(Collectors.joining(" "));
        System.out.println(res);

        String s1 = "blast";
        int len=s1.length();
        res = IntStream.range(0, len).           // create index [0 .. s.length - 1]
                boxed().                               // the next step requires them boxed
                sorted(Collections.reverseOrder()).    // indices in reverse order
                map(i -> String.valueOf(s1.charAt(i))). // grab each index's character
                collect(Collectors.joining());
        System.out.println(res);

    }

    public static void wordReverseFromStrData() {
        // Input String
        String input = "Jani is name my";
        String[] ar=input.split(" ");
        int len=ar.length;

        // Split the string by space and reverse the order of words using IntStream
        String[] reversedArray = IntStream.range(0, len)  // Create a stream of indices
                .mapToObj(i -> ar[len - 1 - i])  // Access elements in reverse order
                .toArray(String[]::new);  // Collect the reversed elements into a new String array

        String res = IntStream.range(0, len)  // Create a stream of indices
                .mapToObj(i -> ar[len - 1 - i])  // Access elements in reverse order
                .collect(Collectors.joining(" "));
        System.out.println(res);

        res=IntStream.range(0, len)  // Create a stream of indices
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(i -> ar[i])
                .collect(Collectors.joining(" "));
        System.out.println(res);

        res=Arrays.stream(ar)
                .reduce((f,s) -> s +" "+f).orElse("");
        System.out.println(res);

        res=Stream.of(ar)
                .reduce((f,s) -> s +" "+f).orElseGet(()->"");
        System.out.println(res);

        Integer[] k={1,2,3};

        Integer rs=Arrays.stream(k)
                .reduce((f,s) -> s * f).orElse(0);
        System.out.println(rs);
        // Output the reversed array
        System.out.println("Reversed String Array: " + Arrays.toString(reversedArray));

        System.out.println(String.join(" ", reversedArray));
    }
}