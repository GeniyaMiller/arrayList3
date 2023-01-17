package com.skypro.arraylist.arrayList;

import com.skypro.arraylist.exceptions.ArrayIndexOutOfBoundsException1;
import com.skypro.arraylist.exceptions.ArrayIsFullException;
import com.skypro.arraylist.exceptions.NullPointerException1;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] stringList;
    private int size;

    public StringListImpl(int size) {
        this.size = size;
        this.stringList = new String[size];
    }

    private void nullException(String item) {
        if (item == null) {
            throw new NullPointerException1("Введите корректные данные");
        }
    }

    private void indexOut(int index) {
        if (index > stringList.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException1("Такого элемента не существует");
        }
    }

    private void validateSize() {
        if (size == stringList.length) {
            throw new ArrayIsFullException("Массив заполнен");
        }
    }


    @Override
    public String add(String item) {
        nullException(item);
        validateSize();
        stringList[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        nullException(item);
        indexOut(index);
        validateSize();
        if (index == size) {
            stringList[size++] = item;
            return item;
        }
        System.arraycopy(stringList,index,stringList,index + 1,size - index);
        stringList[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        nullException(item);
        indexOut(index);
        stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        nullException(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        indexOut(index);
        String item = stringList[index];
        remove(item);
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (stringList[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0 ; i--) {
            if (stringList[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateSize();
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
       return Arrays.equals(otherList.toArray(),stringList);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringList,size);
    }

    public String[] getStringList() {
        return stringList;
    }

    public void setStringList(String[] stringList) {
        this.stringList = stringList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
