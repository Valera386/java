/**
 * Класс, представляющий пользователя библиотеки.
 * Содержит информацию о пользователе, включая ID и имя.
 */
public class User {
    private int id;
    private String name;

    /**
     * Создает нового пользователя с указанными параметрами.
     * @param id уникальный идентификатор пользователя
     * @param name имя пользователя
     */
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Возвращает ID пользователя.
     * @return ID пользователя
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает имя пользователя.
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает строковое представление пользователя.
     * @return строка с информацией о пользователе
     */
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}