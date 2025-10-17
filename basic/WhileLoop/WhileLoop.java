import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода чисел
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int number;

        // Запрашиваем числа, пока не введен 0
        System.out.println("Введите число (0 для завершения):");
        number = scanner.nextInt();
        while (number != 0) {
            sum += number;
            System.out.println("Введите число (0 для завершения):");
            number = scanner.nextInt();
        }

        // Выводим итоговую сумму
        System.out.println("Сумма всех введенных чисел: " + sum);

        scanner.close();
    }
}