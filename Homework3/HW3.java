
package ExceptionsAndProcessInProgr.Homework3;

import java.io.*;
import java.text.*;
import java.util.*;

class UserDataValidation {

    static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        // Используем try-with-resources для автоматического закрытия ресурса
        try (Scanner scanner = new Scanner(System.in)) {

            // Запрос данных у пользователя
            System.out.println("Введите данные: Фамилия Имя Отчество дата_рождения номер_телефона пол");
            String input = scanner.nextLine();

            // Разбиение данных по пробелам
            String[] data = input.split(" ");

            // Проверка количества данных
            if (data.length != 6) {
                System.out.println("Ошибка: введено " + data.length + " данных. Ожидалось 6.");
                return;
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            try {
                // Проверка корректности даты
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                dateFormat.setLenient(false); // Отключение строгой проверки
                dateFormat.parse(birthDate);

                // Проверка номера телефона (целое беззнаковое число)
                Long.parseLong(phoneNumber);

                // Проверка корректности пола
                if (!gender.equals("f") && !gender.equals("m")) {
                    throw new InvalidDataException("Неверный формат пола, ожидается 'f' или 'm'.");
                }

                // Запись данных в файл
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true))) {
                    writer.write(surname + name + patronymic + birthDate + " " + phoneNumber + gender);
                    writer.newLine();
                    System.out.println("Данные успешно записаны в файл " + surname + ".txt");
                } catch (IOException e) {
                    System.out.println("Ошибка при записи в файл.");
                    e.printStackTrace();
                }

            } catch (ParseException e) {
                System.out.println("Ошибка: неверный формат даты. Ожидается dd.MM.yyyy.");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: неверный формат номера телефона. Ожидается целое беззнаковое число.");
            } catch (InvalidDataException e) {
                System.out.println(e.getMessage());
            }

        } // Здесь Scanner автоматически закрывается благодаря try-with-resources
    }
}
