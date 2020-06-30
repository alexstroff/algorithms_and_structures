package Lesson2;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(5,1,4,1,3,2,1);
        System.out.println(array.toString());
//        array.sortCount();
//        array.sortBubble();
//        array.sortInsert();
//        array.sortSelect();
//        array.insert(0,3);
//        array.deleteVal(88);
//        array.deleteIndex(0);
//        array.deleteAll();
        array.sortCount2();
        System.out.println(array.toString());


    }
}
