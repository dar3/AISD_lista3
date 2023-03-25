package com.company;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoWayLinkedList<T> {

    Element head = null;

    private class Element{
        private T value;
        private Element next;
        private Element prev;
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public Element getNext() {
            return next;
        }
        public void setNext(Element next) {
            this.next = next;
        }
        public Element getPrev() {
            return prev;
        }
        public void setPrev(Element prev) {
            this.prev = prev;
        }
        Element(T data){
            this.value= data;
            this.next = null;
            this.prev = null;

        }
        /** elem bêdzie stawiony <b> za this </b>*/
//        public void insertAfter(Element elem){
//            elem.setNext(this.getNext());
//            elem.setPrev(this);
//            this.getNext().setPrev(elem);
//            this.setNext(elem);
//        }
        /** elem bêdzie stawiany <b> przed this </b>*/
//        public void insertBefore(Element elem){
//            elem.setNext(this);
//            elem.setPrev(this.getPrev());
//            this.getPrev().setNext(elem);
//            this.setPrev(elem);
//        }
        /** elem bêdzie usuwany z listy w której jest <p>
         * <b>Za³o¿enie:</b> element jest ju¿ umieszczony w liœcie i nie jest to sentinel */
//        public void remove(){
//            this.getNext().setPrev(this.getPrev());
//            this.getPrev().setNext(this.getNext());
//        }
    }


    public void add(T value) {

        Element newElem = new Element(value);
        if(head == null){
            head = newElem;
        }
        else {
//            przesuwamy wskaznik do konca listy aby znalezc jej koniec
//             po zakonczeniu while tail jest ostatnim elementem (wskazuje na ostatni element)
            Element tail = head;
            while (tail.getNext() != null){
                tail = tail.getNext();
            }
//            wskazujemy tailem na nowy element
            tail.setNext(newElem);
//            dodajemy nowemu elementowi wskaznik na jego poprzednika
            newElem.setPrev(tail);
        }


    }

    public void addAt(int index, T value) throws NoSuchElementException {
        // TODO
        Element newElem = new Element(value);

        Element current = head;
        int counter = 0;
        while (current.getNext() != null && counter < index){
            counter ++;
            current = current.getNext();
        }

        if(counter < index){

            throw new  NoSuchElementException();
        }
        if(head == current){
            head = newElem;
        }
        newElem.setNext(current);
        current.setPrev(newElem);

    }

    public void clear() {
        // TODO
    }

    public boolean contains(T value) {
        // TODO
        return false;
    }

    public T get(int index) throws NoSuchElementException {
        // TODO
        Element elem = head;
        int counter = 0;
        while(elem != null && counter < index){
            counter++;
            elem = elem.getNext();
        }
        if(elem == null){
            throw new NoSuchElementException();
        }
        else {
            return elem.getValue();
        }
    }

    public void set(int index, T value) throws NoSuchElementException {
        // TODO
    }

    public int indexOf(T value) {
        // TODO
        return 0;
    }

    public boolean isEmpty() {

       return head == null;
    }

    public T removeAt(int index) throws NoSuchElementException {
        // TODO
        return null;
    }

    public boolean remove(T value) {
        // TODO
        return false;
    }

    public int size() {
        // TODO
        return 0;
    }

    public Iterator<T> iterator() {
        return new TwoWayLinkedListIterator();
    }

    private class TwoWayLinkedListIterator implements Iterator<T> {

        Element currentElement = head;

        @Override
        public boolean hasNext() {
            return currentElement != null;
        }

        @Override
        public T next() {
            // TODO
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            currentElement = currentElement.getNext();
            return currentElement.getPrev().getValue();
        }
    }

    public void insert(
            TwoWayLinkedList<T> anotherList,
            int beforeIndex) throws NoSuchElementException {
        // TODO
    }

    public void insert(
            TwoWayLinkedList<T> anotherList,
            T beforeElement) throws NoSuchElementException {
        // TODO
    }
}
