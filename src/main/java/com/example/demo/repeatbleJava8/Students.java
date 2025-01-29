package com.example.demo.repeatbleJava8;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Students {
    Student[] value();
}
