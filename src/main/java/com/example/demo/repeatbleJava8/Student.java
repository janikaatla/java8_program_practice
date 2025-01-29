package com.example.demo.repeatbleJava8;

import java.lang.annotation.Repeatable;

@Repeatable(Students.class) // after java8
public @interface Student {
String name();
String address();
}
