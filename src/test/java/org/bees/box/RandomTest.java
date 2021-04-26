package org.bees.box;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class RandomTest {
    //是ParameterizedType
    private HashMap<String, Object> map;
    private HashSet<String> set;
    private List<String> list;
    private Class<?> clz;

    //不是ParameterizedType
    private Integer i;
    private String str;


    public static void main(String[] args) throws InterruptedException {
        array = new int[]{5, 9, 1, 9, 5, 3, 7, 6, 1};
        sort();
        print();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

        new RandomTest().hashCode();
    }

    private static int[] array;

    public static void sort() {
        quickSort(array, 0, array.length - 1);
    }
    public static void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 递归排序
     * @param src
     * @param begin
     * @param end
     */
    private static void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }
            }
            src[i] = key;
            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }
    }
}
