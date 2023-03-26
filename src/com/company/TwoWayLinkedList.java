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
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Element newElem = new Element(value);

        Element current = head;
        while (current.getNext() != null && index > 0){
            index--;
            current = current.getNext();
        }

        if(current == tail && index > 0){
            if(index > 1){
                throw new NoSuchElementException();
            }else {
                add(value);
            }
        }
        else{

            if(index < 0){
                throw new  NoSuchElementException();
            }
            if(head == current){
                newElem.setNext(head);
                newElem.setPrev(null);
                head.setPrev(newElem);
                head = newElem;
            }
            else{
                current.getPrev().setNext(newElem);
                newElem.setPrev(current.getPrev());
                newElem.setNext(current);
                current.setPrev(newElem);
            }
        }


    }

    public void clear() {
        head = null;
        tail = null;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public T get(int index) throws NoSuchElementException {
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
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Element current = head;
        if(index < 0){
            throw new NoSuchElementException();
        }
        while (current.getNext() != null && index > 0){
            index--;
            current = current.getNext();
        }
        if(index > 0){
            throw new NoSuchElementException();
        }
        else {
            current.setValue(value);
        }
    }

    public int indexOf(T value) {
        Element current = head;
        int counter = 0;
        while(!value.equals(current.getValue()) && current != tail) {
            counter++;
            current = current.getNext();
        }
        if(!value.equals(current.getValue())){
            return -1;
        }

        return  counter;
    }



    public boolean isEmpty() {

       return head == null;
    }

    public T removeAt(int index) throws NoSuchElementException {

        Element current = head;

        if(isEmpty()){
            throw new NoSuchElementException();
        }

        if(index == 0){
            if(current.getNext() != null){

                current.getNext().setPrev(null);
                head = current.getNext();
                return current.getValue();

            }else{
                clear();
                return current.getValue();
            }
        }
        if(index < 0){
            throw new NoSuchElementException();
        }
        while (current.getNext() != null && index > 0){
            index--;
            current = current.getNext();
        }

        if(index > 0){
            throw new NoSuchElementException();
        }
        else {
            if(current.getNext() == null && current.getPrev() != null){
                current.getPrev().setNext(null);
                return current.getValue();
            }
            if(current.getNext() == null){
                current.setPrev(null);
            }
            else {
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            }

        }
      return current.getValue();
    }

    public boolean remove(T value) {
        // TODO
        Element current = head;
        while(!value.equals(current.getValue()) && current != tail) {
            current = current.getNext();
        }
        if(!value.equals(current.getValue())){
            return false;
        }else {
            if(current != head){

                current.getPrev().setNext(current.getNext());
            } else {

                if(current != tail){
                    current.getNext().setPrev(current.getPrev());
                    head = current.getNext();
                }
            }
            return true;
        }
    }

    public int size() {
        // TODO
        Element current = head;
        if(head == null){
            return 0;
        }
        int counter = 1;
        while (current.getNext() != null) {
            counter++;
            current = current.getNext();

        }

        return counter;
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
        for (int i = anotherList.size(); i > 0; i--){

            addAt(beforeIndex, anotherList.get(i-1));
        }
    }

    public void insert(
            TwoWayLinkedList<T> anotherList,
            T beforeElement) throws NoSuchElementException {
        // TODO
       int index = indexOf(beforeElement);

       insert(anotherList, index);

    }
}
