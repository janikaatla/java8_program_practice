package com.example.demo.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsImpls {

    public static void main(String[] arg) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(1,1);
        LinkedHashMap<Integer, Integer> lhm=new LinkedHashMap<>();
        lhm.put(1,2);

        ConcurrentHashMap<Integer, Integer> chm=new ConcurrentHashMap<>();
        chm.put(1,1);
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(1);
    }
}
