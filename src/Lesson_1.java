public class Lesson_1 {

    /*
    11 Возведение в степень (*используя чётность степени)
    Сложность алгоритма - О(2N + 2). Вначале объявляем переменную;
    далее проходим цикл N раз и N раз производим действие с переменной;
    в конце возвращаем полученное значение
     */
    public static int method1(int num, int degree){
        int x = 1;
        for (int i = 0; i < degree; i++) {
            x *= num;
        }
        return  x;
    }

    /*
    12 Поиск минимального элемента в массиве
    Сложность алгоритма - О(3(N - 1) + 2). Вначале объявляем переменную;
    далее проходим цикл (N - 1) раз, (N - 1) раз производим проверку переменной,
    (N - 1) раз производим присваивание нового значения;
    в конце возвращаем полученное значение
     */

    public static  int method2(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    /*
    13 Нахождение среднего арифметического массива
        Сложность алгоритма - О(2(N) + 3).
        Вначале объявляем переменную;
        Далее проходим по циклу N раз и N раз производим действие с переменной;
        После прохождения цикла однократно соверщаем действие с переменной и возвращаем значениеж
    */

    public  static double method3 (int[] arr){
        double avr = 0;
        for (int value : arr) {
            avr += value;
        }
        return avr/arr.length;
    }



    public static void main(String[] args) {
        System.out.println(method1(2, 5));
        System.out.println(method2(new int[]{5, -100, 3}));
        System.out.println(method3(new int[] {1, 2, 3, 3}));
    }
}
