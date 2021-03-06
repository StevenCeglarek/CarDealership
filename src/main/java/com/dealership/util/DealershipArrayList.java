package com.dealership.util;

import com.dealership.model.Car;
import com.dealership.model.User;

import java.util.ArrayList;

public class DealershipArrayList<T> extends DealershipList<T> {

//    ArrayList<Integer> arr;
    protected T[] array;
    protected int currentIndex = 0;

    public DealershipArrayList() {
        this.array = (T[]) new Object[]{};
    }

    public DealershipArrayList(T[] array) {
        this.array = array;
    }

    public T get(int i) {
        return array[i];
    }

    @Override
    public T get(T c) {
        return null;
    }

    public void add(T t){
        T[] newArray = (T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        // add new element
        newArray[array.length] = t;
        array = newArray;
    }

    public int size() {
        return array.length;
    }

    public void remove(T t) {
        int index = indexOf(t);
        T[] temp = (T[]) new Object[array.length - 1];

        for (int i = index; i < (array.length - 1); i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = null;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }

        array = temp;
    }

//    public String toString() {
//        return null;
//    }

    boolean isEmpty() {
        return false;
    }

    protected void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    public void order() {

    }

    public int indexOf(T t) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(t)) {
                return i;
            }
            return 0;
        }
        return -1;
    }

    public String toString() {
        String[] strings = getStringArray();
        String result = "";
        for (String s : strings) {
            result = result.concat(s + System.lineSeparator());
        }
        return result;
    }

    public String[] getStringArray(){
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++){
            result[i] = i + "." + array[i].toString();
        }
        return result;
    }
}
