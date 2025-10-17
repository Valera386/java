import java.util.Random;
import java.util.Scanner;

public class DoWhileLoop {
    public static void main(String[] args) {
        // Создаем объекты Random и Scanner
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Генерируем случайное число от 1 до 10
        int targetNumber = random.nextInt(10) + 1;
        int userGuess;

        // Цикл do-while для угадывания числа
        do {
            System.out.println("Введите число от 1 до 10:");
            userGuess = scanner.nextInt();
        } while (userGuess != targetNumber);

        // Выводим сообщение об успехе
        System.out.println("Вы угадали!");

        scanner.close();
    }
}