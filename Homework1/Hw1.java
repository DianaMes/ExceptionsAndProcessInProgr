// Задание 1. Преобразование строки в число
// Реализуйте метод convertAndSum, который принимает массив строк, каждая
// из которых должна быть преобразована в целое число. Метод возвращает
// сумму всех чисел. Если хотя бы одна строка не может быть преобразована в
// число, метод должен выбросить исключение NumberFormatException.
// Дополнительно, если сумма чисел превышает 100, выбрасывайте
// ArithmeticException с сообщением "Превышен лимит суммы".

package ExceptionsAndProcessInProgr.Homework1;

public class Hw1 {
    public static void main(String[] args) {
        // Первая попытка: корректный ввод
        try {
            String[] strings = { "10", "20", "70" };
            System.out.println(Answer.convertAndSum(strings)); // Ожидаемый результат: 100
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        // Вторая попытка: ввод с некорректным числом
        try {
            String[] invalidStrings = { "10", "20", "abc" };
            System.out.println(Answer.convertAndSum(invalidStrings));
            // Ожидаемый результат: исключение NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        // Третья попытка: сумма превышает лимит
        try {
            String[] overLimitStrings = { "50", "60" };
            System.out.println(Answer.convertAndSum(overLimitStrings)); // Ожидаемый результат: исключение
                                                                        // ArithmeticException
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

}

class Answer {
    public static int convertAndSum(String[] strings) {
        int sum = 0;
        for (String s : strings) {
            try {
                int number = Integer.parseInt(s);
                sum += number;
            } catch (NumberFormatException e) {
                // Перехватываем ошибку преобразования и выбрасываем снова
                throw new NumberFormatException("Ошибка преобразования строки в число: " + s);
            }
        }
        if (sum > 100) {
            throw new ArithmeticException("Превышен лимит суммы");
        }
        return sum;
    }
}
