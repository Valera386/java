public class ContinueOperator {
    public static void main(String[] args) {
        // Выводим четные числа от 1 до 20
        for (int i = 1; i <= 20; i++) {
            if (i % 2 != 0) {
                continue; // Пропускаем нечетные числа
            }
            System.out.print(i + " ");
        }
    }
}