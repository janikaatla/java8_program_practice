package com.example.demo.java8programs;


public class Emp {
    private String name;
    private Integer dep;

    public Emp(String name, Integer dep) {
        this.name = name;
        this.dep = dep;
    }

    public String getName() {
        return name;
    }

    public Integer getDep() {
        return dep;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", dep=" + dep +
                '}';
    }
}
