/**
 * Класс PairTask содержит метод main для тестирования класса Pair с различными типами данных.
 * Проводит демонстрацию работы с Integer, String и Double.
 */
public class PairTask {
    /**
     * Точка входа в программу, запускающая тесты пар с разными типами данных.
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Тестирование с Integer
        Pair<Integer> intPair = new Pair<>(10, 5);
        System.out.println("Integer Pair: Max = " + intPair.getMax() + ", Min = " + intPair.getMin());

        // Тестирование с String
        Pair<String> stringPair = new Pair<>("apple", "banana");
        System.out.println("String Pair: Max = " + stringPair.getMax() + ", Min = " + stringPair.getMin());

        // Тестирование с Double
        Pair<Double> doublePair = new Pair<>(3.14, 2.71);
        System.out.println("Double Pair: Max = " + doublePair.getMax() + ", Min = " + doublePair.getMin());
    }
}