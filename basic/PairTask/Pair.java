/**
 * Класс Pair представляет собой обобщенную пару объектов типа T, где T реализует интерфейс Comparable<T>.
 * Позволяет хранить два элемента и определять максимальный и минимальный из них.
 * @param <T> тип элементов пары, должен реализовывать интерфейс Comparable<T>
 */
class Pair<T extends Comparable<T>> {
    private T first;
    private T second;

    /**
     * Создает новую пару с указанными элементами.
     * @param first первый элемент пары
     * @param second второй элемент пары
     */
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Возвращает первый элемент пары.
     * @return первый элемент
     */
    public T getFirst() {
        return first;
    }

    /**
     * Возвращает второй элемент пары.
     * @return второй элемент
     */
    public T getSecond() {
        return second;
    }

    /**
     * Возвращает максимальный элемент пары на основе сравнения.
     * @return максимальный элемент
     * @throws IllegalStateException если один из элементов null
     */
    public T getMax() {
        if (first == null || second == null) {
            throw new IllegalStateException("Cannot compare null values");
        }
        return first.compareTo(second) >= 0 ? first : second;
    }

    /**
     * Возвращает минимальный элемент пары на основе сравнения.
     * @return минимальный элемент
     * @throws IllegalStateException если один из элементов null
     */
    public T getMin() {
        if (first == null || second == null) {
            throw new IllegalStateException("Cannot compare null values");
        }
        return first.compareTo(second) <= 0 ? first : second;
    }
}