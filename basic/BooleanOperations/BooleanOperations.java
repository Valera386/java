import java.util.Scanner;

public class BooleanOperations {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода года
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год:");
        int year = scanner.nextInt();

        // Проверяем, является ли год високосным
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Выводим результат
        if (isLeapYear) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }

        scanner.close();
    }
}