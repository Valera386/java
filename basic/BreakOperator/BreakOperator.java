import java.util.Scanner;

public class BreakOperator {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода числа
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = scanner.nextInt();

        // Проверяем, является ли число меньше 2
        if (number < 2) {
            System.out.println("Число должно быть больше или равно 2");
            scanner.close();
            return;
        }

        // Ищем первый делитель
        boolean isPrime = true;
        int divisor = 0;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                divisor = i;
                isPrime = false;
                break; // Выходим из цикла после нахождения первого делителя
            }
        }

        // Выводим результат
        if (isPrime) {
            System.out.println("Число простое");
        } else {
            System.out.println("Первый делитель: " + divisor);
        }

        scanner.close();
    }
}