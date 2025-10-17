import java.util.Scanner;
import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args) {
        // Создаем массив из 5 чисел, введенных пользователем
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        System.out.println("Введите 5 целых чисел:");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        // Выводим исходный массив
        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Находим сумму элементов
        int sum = calculateSum(array);
        System.out.println("Сумма элементов: " + sum);

        // Находим среднее арифметическое
        double average = calculateAverage(array);
        System.out.println("Среднее арифметическое: " + average);

        // Проверяем наличие отрицательных чисел
        boolean hasNegative = hasNegative(array);
        System.out.println("Есть ли отрицательные числа: " + hasNegative);

        scanner.close();
    }

    // Метод для вычисления суммы элементов
    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    // Метод для вычисления среднего арифметического
    public static double calculateAverage(int[] array) {
        return (double) calculateSum(array) / array.length;
    }

    // Метод для проверки наличия отрицательных чисел
    public static boolean hasNegative(int[] array) {
        for (int num : array) {
            if (num < 0) {
                return true;
            }
        }
        return false;
    }
}