import java.util.Random;
import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {
        // Создаем массив из 6 случайных чисел
        int[] array = new int[6];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1; // Числа от 1 до 10
        }

        // Выводим исходный массив
        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Находим максимальный элемент
        int max = findMax(array);
        System.out.println("Максимальный элемент: " + max);

        // Сортируем массив по убыванию
        int[] sortedArray = sortDescending(array);
        System.out.println("Массив, отсортированный по убыванию: " + Arrays.toString(sortedArray));

        // Заменяем четные числа на 0
        replaceEvenWithZero(array);
        System.out.println("Массив после замены четных чисел на 0: " + Arrays.toString(array));
    }

    // Метод для поиска максимального элемента
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Метод для сортировки массива по убыванию
    public static int[] sortDescending(int[] array) {
        int[] sorted = array.clone(); // Создаем копию массива
        Arrays.sort(sorted); // Сортируем по возрастанию
        // Переворачиваем массив для сортировки по убыванию
        for (int i = 0; i < sorted.length / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[sorted.length - 1 - i];
            sorted[sorted.length - 1 - i] = temp;
        }
        return sorted;
    }

    // Метод для замены четных чисел на 0
    public static void replaceEvenWithZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
    }
}