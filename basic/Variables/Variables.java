import java.util.Scanner;

public class Variables {
    public static void main(String[] args) {
        // Создаем объект Scanner для ввода данных
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем доход и расходы
        System.out.println("Введите месячный доход (в рублях):");
        double income = scanner.nextDouble();

        System.out.println("Введите расходы на еду (в рублях):");
        double foodExpenses = scanner.nextDouble();

        System.out.println("Введите расходы на жилье (в рублях):");
        double housingExpenses = scanner.nextDouble();

        System.out.println("Введите расходы на транспорт (в рублях):");
        double transportExpenses = scanner.nextDouble();

        // Вычисляем остаток бюджета
        double balance = income - (foodExpenses + housingExpenses + transportExpenses);

        // Выводим результат
        System.out.println("Остаток бюджета: " + balance + " рублей");

        scanner.close();
    }
}