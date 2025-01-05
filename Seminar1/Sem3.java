// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
// Необходимо посчитать и вернуть сумму элементов этого массива.
// При этом накладываем на метод 2 ограничения: метод может работать только с
// квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
// только значение 0 или 1.
// Если нарушается одно из условий, метод должен вернуть код ошибки.
// Программа должна корректно обработать код ошибки и вывести соответствующее
// сообщение пользователю.
// Сравнить такой вариант обработки исключений с предыдущим.
// Какое преимущество у исключений перед
// кодами ошибок вы можете назвать
// в данном случае?

public class Sem3 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        int result = sumElements(matrix);
        if (result == -1) {
            System.out.println("Кол-во строк не равно кол-ву столбцов");
        } else if (result == -2) {
            System.out.println("Массив должен содержать только 0 и 1");
        } else {
            System.out.printf("Сумма элементов %d", result);
        }

    }

    public static int sumElements(int[][] matrix) {
        int n = matrix.length;
        for (int[] row : matrix) {
            if (row.length != n) {
                return -1;
            }
        }
        for (int[] row : matrix) {
            for (int element : row) {
                if (element != 0 && element != 1) {
                    return -2;
                }
            }
        }
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;

    }

}
