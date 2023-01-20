package com.skypro.arraylist.IntegerList;

import java.util.Arrays;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    private int size;

    public IntegerListImpl(int size) {
        this.size = size;
        this.integerList = new Integer[size];
    }

    private void nullException(Integer item) {
        if (item == null) {
            throw new NullPointerException("Введите корректные данные");
        }
    }

    private void indexOut(int index) {
        if (index > integerList.length - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Такого элемента не существует");
        }
    }

    private void growIfNeeded() {
        if (size == integerList.length) {
            grow();
        }
    }


    @Override
    public Integer add(Integer item) {
        nullException(item);
        growIfNeeded();
        integerList[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        nullException(item);
        indexOut(index);
        growIfNeeded();
        if (index == size) {
            integerList[size++] = item;
            return item;
        }
        System.arraycopy(integerList,index,integerList,index + 1,size - index);
        integerList[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        nullException(item);
        indexOut(index);
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        nullException(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        indexOut(index);
        Integer item = integerList[index];
        remove(item);
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return IntegerListImpl.binarySearch1(Arrays.copyOf(integerList,integerList.length), item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integerList[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0 ; i--) {
            if (integerList[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        growIfNeeded();
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(otherList.toArray(),integerList);
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
    public Integer[] toArray() {
        return Arrays.copyOf(integerList,size);
    }    

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "integerList=" + Arrays.toString(integerList) +
                ", size=" + size +
                '}';
    }

    // Заполняем рандомными целыми
    public static Integer[] toRandomArray(){
        Integer[] integersArray = new Integer[100000];
        for (int i = 0; i < integersArray.length; i++) {
            integersArray[i] = new Random().nextInt(10000);
        }
        return integersArray;
    }

    //Пузырькова сортировка
    public static void sortBubble(Integer[] integersArray) {
        for (int i = 0; i < integersArray.length - 1; i++) {
            for (int j = 0; j < integersArray.length - 1 - i; j++) {
                if (integersArray[j] > integersArray[j + 1]) {
                    swapElements(integersArray, j, j + 1);
                }
            }
        }
    }

    //Сортировка выбором

    public static void sortSelection(Integer[] integersArray) {
        for (int i = 0; i < integersArray.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integersArray.length; j++) {
                if (integersArray[j] < integersArray[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integersArray, i, minElementIndex);
        }
    }

    //Сортировка вставкой

    public static void sortInsertion(Integer[] integersArray) {
        for (int i = 1; i < integersArray.length; i++) {
            int temp = integersArray[i];
            int j = i;
            while (j > 0 && integersArray[j - 1] >= temp) {
                integersArray[j] = integersArray[j - 1];
                j--;
            }
            integersArray[j] = temp;
        }
    }

    // Сортировка

    public void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //Поиск

    private static int binarySearch1(Integer[] integers, Integer item) {
        IntegerListImpl.sortInsertion(integers);
        return Arrays.binarySearch(integers, item);
    }

    // Быстрая сортировка

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }


    private static void swapElements(Integer[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    private void grow() {
        integerList = Arrays.copyOf(integerList, size + size/2);
    }

    public static void main(String[] args) {
        Integer[] integers1 = IntegerListImpl.toRandomArray();
        Integer[] integers2 = IntegerListImpl.toRandomArray();
        Integer[] integers3 = IntegerListImpl.toRandomArray();

        long start1 = System.currentTimeMillis();
        sortInsertion(integers1);
        System.out.println("Сортировка вставкой " + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        sortBubble(integers2);
        System.out.println("Пузырьковая сортировка " + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        sortSelection(integers3);
        System.out.println("Сортировка выбором " + (System.currentTimeMillis() - start3));
    }

}
