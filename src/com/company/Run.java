package com.company;

import java.util.Iterator;

public class Run {

    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();
        TwoWayLinkedList<String> list2 = new TwoWayLinkedList<>();
        list.add("d");
        list.add("e");
        list.add("f");

        list2.add("a");
        list2.add("b");
        list2.add("c");

        list.insert(list2,2);

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.remove("c");
//        list.addAt(0, "v");
//        list.addAt(1, "test123");
//        list.add("b");
//        list.add("c");

//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(array[0]);
//        System.out.println(list.indexOf("v"));
//        System.out.println(list.indexOf("test123"));


    }





}
