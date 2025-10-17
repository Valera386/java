import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода числа
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int number = scanner.nextInt();

        // Выводим таблицу умножения с использованием цикла for
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        scanner.close();
    }
}