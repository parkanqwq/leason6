package com.company;

      /*  Задание 6.1
            Приведите пример использования древовидной структуры.
            Создание базы данных людей для справочника или создание
            данных для хранения одежды и быстрое получение из

        Задание 6.7
            Пример сбалансированного дерева, когда, для любого узла дерева
            высота его правого поддерева отличается от высоты левого поддерева не более чем на единицу.
            Применять его можно при подходящей ситуации, и это дает всегда наилучшее время с работой с ним.
        */

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Tree theTree = new Tree();

        theTree.insert(new Person(4, "Ivan", 35));
        theTree.insert(new Person(2, "Ivan1", 78));
        theTree.insert(new Person(3, "Ivan2", 24));
        theTree.insert(new Person(5, "Ivan3", 21));

        long a = System.nanoTime();

        theTree.max().display();
        theTree.min().display();

        theTree.find(3).display();

        theTree.delete(2);

        System.out.println();

        theTree.displayTree();

        System.out.println();
        System.out.println("время на методы дерева " + (System.nanoTime() - a));
        System.out.println();

        int[] arr = new int[400];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(359);
        }

        System.out.println("не сорт массив " + Arrays.toString(arr));

        long c = System.nanoTime();
        HeapSort heapSort = new HeapSort();
        System.out.println("Сорт массив tree ");
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Время на сорт деревом " + (System.nanoTime() - c));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(359);
        }

        long b = System.nanoTime();
        System.out.println("Сорт массив слиянием " + Arrays.toString(sortMarge(arr)));
        System.out.println(System.nanoTime() - b + " Столько нано секунд потребовалось на слияние");
        System.out.println();
    }

    private static int[] sortMarge(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merg(sortMarge(Arrays.copyOfRange(arr, 0, middle)),
                sortMarge(Arrays.copyOfRange(arr, middle, len)));
    }

    private static int[] merg(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if (bIndex == b.length){
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
