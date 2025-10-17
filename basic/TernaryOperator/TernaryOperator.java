import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода числа
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int number = scanner.nextInt();

        // Используем тернарный оператор для определения четности
        String result = (number % 2 == 0) ? "четное" : "нечетное";

        // Выводим результат
        System.out.println("Число " + number + " - " + result);

        scanner.close();
    }
}