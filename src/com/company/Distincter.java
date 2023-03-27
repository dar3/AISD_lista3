package com.company;

import java.util.Iterator;

public class Distincter {
    public static TwoWayLinkedList<Integer> distinct(TwoWayLinkedList<Integer> list) {
        // TODO: Zwróć nową listę zawierającą unikalne wartości w liście źródłowej.
        // Możesz założyć, że lista na wejściu jest posortowana.
        // Przykład: [1, 1, 2, 3, 3] -> [1, 2, 3]

        TwoWayLinkedList<Integer> resultList = new TwoWayLinkedList<>();
        Iterator<Integer> iterator = list.iterator();
        if (!list.isEmpty()) {
        while (iterator.hasNext()){
            int num = iterator.next();
            if (!resultList.contains(num)) {
                resultList.add(num);
            };
        }
        }
        return resultList;
    }
}
