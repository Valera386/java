import java.util.Scanner;

public class NestedConditions {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода оценки
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите оценку (от 0 до 100):");
        int score = scanner.nextInt();

        // Проверяем допустимость оценки
        if (score < 0 || score > 100) {
            System.out.println("Недопустимая оценка");
        } else {
            // Определяем буквенный эквивалент с помощью вложенных if-else
            if (score >= 90) {
                System.out.println("Оценка: A");
            } else if (score >= 80) {
                System.out.println("Оценка: B");
            } else if (score >= 70) {
                System.out.println("Оценка: C");
            } else if (score >= 60) {
                System.out.println("Оценка: D");
            } else {
                System.out.println("Оценка: F");
            }
        }

        scanner.close();
    }
}