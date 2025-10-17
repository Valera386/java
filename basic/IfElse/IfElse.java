import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода возраста
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш возраст:");
        int age = scanner.nextInt();

        // Проверяем категорию возраста с использованием if-else
        if (age < 18) {
            System.out.println("Вы ребенок");
        } else if (age >= 18 && age <= 65) {
            System.out.println("Вы взрослый");
        } else {
            System.out.println("Вы пенсионер");
        }

        scanner.close();
    }
}