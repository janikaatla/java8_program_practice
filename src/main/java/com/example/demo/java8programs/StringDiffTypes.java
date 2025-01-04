package com.example.demo.java8programs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringDiffTypes {
    public static void main(String[] args) {
        // Input String
        String input = "Jani is name my";

        // Split the string by space and reverse the order of words using IntStream
        String[] reversedArray = IntStream.range(0, input.split(" ").length)  // Create a stream of indices
            .mapToObj(i -> input.split(" ")[input.split(" ").length - 1 - i])  // Access elements in reverse order
            .toArray(String[]::new);  // Collect the reversed elements into a new String array

        String res=Arrays.stream(input.split("\\s"))
                .reduce((f,s) -> s +" "+f).orElse("");
        System.out.println(res);

        Integer[] k={1,2,3};

        Integer rs=Arrays.stream(k)
                .reduce((f,s) -> s * f).orElse(0);
        System.out.println(res);
        System.out.println(rs);
        // Output the reversed array
        System.out.println("Reversed String Array: " + Arrays.toString(reversedArray));

        System.out.println(String.join(" ", reversedArray));
    }
}