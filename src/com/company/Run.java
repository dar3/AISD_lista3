package com.company;

public class Run {

    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList<>();
        list.add("a");
        list.addAt(0, "v");
//        list.add("b");
//        list.add("c");

//        System.out.println(array[0]);
        System.out.println(list.get(0));
        System.out.println(list.get(1));


    }





}
