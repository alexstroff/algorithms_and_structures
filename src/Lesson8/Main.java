package Lesson8;

import java.util.Arrays;
import Lesson8.HashCat.Item;

public class Main {
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void qSort(int[] arr, int min, int max) {
        int left = min;
        int right = max;
        int x = arr[(left + right) / 2];
        do {
            while (arr[left] < x) left++;
            while (arr[right] > x) right--;
            if (left <= right) {
                if (arr[left] > arr[right]) {
                    swap(arr, left, right);
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < max) {
            qSort(arr, left, max);
        }
        if (right > min) {
            qSort(arr, min, right);
        }
    }

    public static void main(String[] args) {
        HashCat hashTable = new HashCat(25);
        hashTable.insert(new Item(10));
        hashTable.insert(new Item(20));
        hashTable.insert(new Item(30));
        hashTable.insert(new Item(75));
        hashTable.insert(new Item(40));
        hashTable.insert(new Item(50));
        hashTable.insert(new Item(60));
        hashTable.insert(new Item(70));
        System.out.println(hashTable.toString());
        hashTable.delete(75);
        System.out.println(hashTable.toString());

        int[] arr = {12,54,56,87,34,65,9,89,67,65,80,76};
        System.out.println(Arrays.toString(arr));
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
}
