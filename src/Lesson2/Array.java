package Lesson2;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set (int index, int value) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
    }

    public int length() {
        return size;
    }

    private void increaseCapacity() {
        int[] temp = arr;
        arr = new int[size * 2];
        System.arraycopy(temp, 0, arr, 0, size);
    }

    public void append(int value) {
        if (size >= arr.length) {
            increaseCapacity();
        }
        arr[size++] = value;
        isSorted = false;
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);

        return arr[--size];
    }

    // homework
    // insert(index, value);
    // delete(val);
    // delete(index);
    // deleteAll();

    /*
По моему написанный алгоритм намного медленнее пузырьковой сортировки.
Более приличный вариант в голову не пришел...
 */
    public void sortCount(){
        long start = System.currentTimeMillis();
        int max = arr[0];
        int min = arr[0];
        int x = 0;
        int[] tempArr = new int[size];

        for (int i = 0; i < size; i++) {
            if(arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        int counterPlus[] = new int[max+1];
        int counterMinus[] = new int[-min+1];

        for (int i = 0; i < size; i++) {
            if(arr[i] >= 0){
                counterPlus[arr[i]]++;
            }else {
                counterMinus[-arr[i]]++;
            }
        }
        for (int i = counterMinus.length - 1; i > 0; i--) {
            if (counterMinus[i] != 0){
                for (int j = 0 + x; j < counterMinus[i] + x; j++) {
                    tempArr[j] = -i;
                }
                x += counterMinus[i];
            }
        }
        for (int i = 0; i < counterPlus.length; i++) {
            if (counterPlus[i] != 0){
                for (int j = 0 + x; j < counterPlus[i] + x; j++) {
                    tempArr[j] = i;
                }
                x += counterPlus[i];
            }
        }
        System.arraycopy(tempArr, 0, arr, 0, size);
        isSorted = true;
        System.out.println(System.currentTimeMillis() - start);
    }


    public void insert(int index, int value){
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        if (size >= arr.length) {
            increaseCapacity();
        }
        int[] temp1 = new int[index];
        int[] temp2 = new int[size-index];
        System.arraycopy(arr, 0, temp1, 0, index);
        System.arraycopy(arr, index, temp2, 0, size - index);
        System.arraycopy(temp1, 0, arr, 0, index);
        arr[index] = value;
        System.arraycopy(temp2, 0, arr, index + 1, size++ - index);
        isSorted = false;
    }

    public void deleteVal(int value){
        int[] tmp = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] != value) {
                tmp[count] = arr[i];
                count++;
            }
        }
        if (size == count){
            throw new RuntimeException("No such elemen in array");
        }else {
            size = count;
            System.arraycopy(tmp, 0, arr, 0, size);
        }

    }

    public int deleteIndex(int index){
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        int num = arr[index];
        if (index == 0){
            for (int i = 1; i < size; i++) {
                arr[i - 1] = arr[i];
            }
            size--;
        }else {
            int[] tmp1 = new int[index];
            int[] tmp2 = new int[size - index - 1];
            System.arraycopy(arr, 0, tmp1, 0, index);
            System.arraycopy(arr, index + 1, tmp2, 0, size - index - 1);
            System.arraycopy(tmp1, 0, arr, 0, index - 1);
            System.arraycopy(tmp2, 0, arr, index, size - index - 1);
            size--;
        }
        return num;
    }

    public void deleteAll(){
        size = 0;
    }




    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
        System.out.println(System.currentTimeMillis() - start);
    }

    public void sortSelect() {
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++)
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            swap(flag, cMin);
        }
        isSorted = true;
    }

    public void sortInsert() {
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            int in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
    }
}