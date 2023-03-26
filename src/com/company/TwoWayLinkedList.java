package com.company;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoWayLinkedList<T> {

    Element head = null;
    Element tail = null;

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
    }

    public void add(T value) {

        Element newElem = new Element(value);
        if(head == null){
            head = tail = newElem;
            head.setPrev(null);
            tail.setNext(null);
        }
        else {
            tail.setNext(newElem);
            newElem.setPrev(tail);
            tail = newElem;
            tail.setNext(null);
        }
    }

    public void addAt(int index, T value) throws NoSuchElementException {
        // TODO
        Element newElem = new Element(value);

        Element current = head;
        while (current.getNext() != null && index > 0){
            index--;
            current = current.getNext();
        }

        if(index > 0){
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
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T result = currentElement.getValue();
            currentElement = currentElement.getNext();
            return result;
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
