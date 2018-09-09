package com.springboot.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(l -> {
            if (l.equals("b")) {
                list.remove(l);
            }
        });

        HashMap<String, Integer> hm = new HashMap<String, Integer>() {{
            put("a",1);
            put("b", 2);
            put("c",  3);
            remove("a");
        }};
        Integer a = hm.replace("b",4);
        System.out.println(a);
        hm.forEach((key, val) -> {
            System.out.println(key +"," + val);
        });

    }
}
