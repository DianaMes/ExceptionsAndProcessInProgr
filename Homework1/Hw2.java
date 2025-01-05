package ExceptionsAndProcessInProgr.Homework1;

// Задача 2. Объединение массивов с проверкой длины и содержимого
// Реализуйте метод mergeAndValidateArrays, который принимает два
// массива целых чисел. Метод должен объединить массивы и вернуть новый
// массив. Если длины массивов не равны, выбрасывайте исключение
// IllegalArgumentException. Если хотя бы один элемент объединенного
// массива отрицательный, выбрасывайте исключение RuntimeException с
// сообщением "Обнаружен отрицательный элемент".

import java.util.Arrays;

// package ExceptionsAndProcessInProgr.Homework1;

public class Hw2 {
    public static void main(String[] args) {
        try {
            int[] a = { 1, 2, 3 };
            int[] b = { 4, 5, 6 };
            int[] result = Answer.mergeAndValidateArrays(a, b);
            System.out.println(Arrays.toString(result)); // Ожидаемый результат: [1, 2, 3, 4, 5, 6]
        } catch (IllegalArgumentException e) {
            System.out.println("Длины массивов не равны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            int[] c = { 1, 2 };
            int[] d = { 3, 4, 5 };
            System.out.println(Arrays.toString(Answer.mergeAndValidateArrays(c,
                    d))); // Ожидаемый результат: исключение IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Длины массивов не равны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            int[] e = { -1, 2, 3 };
            int[] f = { 4, 5, 6 };
            System.out.println(Arrays.toString(Answer.mergeAndValidateArrays(e,
                    f))); // Ожидаемый результат: исключение RuntimeException
        } catch (IllegalArgumentException e) {
            System.out.println("Длины массивов не равны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

}

class Answer {
    public static int[] mergeAndValidateArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Длины массивов не равны");
        }
        int[] mergedArray = new int[a.length + b.length];
        System.arraycopy(a, 0, mergedArray, 0, a.length);
        System.arraycopy(b, 0, mergedArray, a.length, b.length);
        for (int num : mergedArray) {
            if (num < 0) {
                throw new RuntimeException("Обнаружен отрицательный элемент");
            }
        }
        return mergedArray;
    }
}