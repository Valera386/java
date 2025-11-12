
**«Менеджер заметок с сохранением в файл и однопоточным планировщиком»**  

**Тема:** Java Collection Framework, Lambda-выражения, Анонимные классы, Аннотации, Работа с файлами, Многопоточность  

---

### Цель  
Создать **простое консольное приложение** — **менеджер заметок**, которое:  
- Хранит заметки в памяти и сохраняет их в файл  
- Позволяет добавлять, удалять, показывать заметки  
- Использует **все указанные технологии**  
- Работает **без GUI**, только консоль  

---

### Функционал (минимум)

1. **Класс `Note`**  
   ```java
   class Note {
       private String text;
       private LocalDateTime createdAt;
       // геттеры, toString()
   }
   ```

2. **Хранение**  
   - `List<Note> notes = new ArrayList<>()`  
   - `Map<String, Note>` — по тексту (если уникальный) или по ID  

3. **Меню (в `main`)**  
   ```
   1. Добавить заметку
   2. Показать все заметки
   3. Удалить заметку по номеру
   4. Сохранить в файл
   5. Загрузить из файла
   6. Запустить "напоминание" (многопоточность)
   0. Выход
   ```

4. **Работа с файлом**  
   - Файл: `notes.txt`  
   - Формат: одна заметка на строку  
     ```
     Купить молоко | 2025-10-31T14:30
     ```
   - Использовать `Files.write()` / `Files.readAllLines()`  
   - При старте — **автоматически загружать** из файла (если есть)

5. **Lambda-выражения**  
   - Фильтрация:  
     ```java
     notes.stream()
          .filter(n -> n.getCreatedAt().isAfter(LocalDateTime.now().minusHours(1)))
          .forEach(System.out::println);
     ```

6. **Анонимный класс**  
   - При удалении заметки:  
     ```java
     Runnable onDelete = new Runnable() {
         public void run() {
             System.out.println("Заметка удалена!");
         }
     };
     onDelete.run();
     ```

7. **Собственная аннотация**  
   ```java
   @Retention(RetentionPolicy.RUNTIME)
   @Target(ElementType.METHOD)
   @interface Task {
       String value();
   }
   ```
   - Пометить метод `saveToFile()`:  
     ```java
     @Task("Сохранение заметок в файл")
     public void saveToFile() { ... }
     ```
   - При запуске вывести:  
     ```java
     Method m = ...getClass().getMethod("saveToFile");
     if (m.isAnnotationPresent(Task.class)) {
         System.out.println("Аннотация: " + m.getAnnotation(Task.class).value());
     }
     ```

8. **Многопоточность (просто!)**  
   - При выборе пункта 6:  
     ```java
     new Thread(() -> {
         System.out.println("Напоминание: у вас " + notes.size() + " заметок!");
         try { Thread.sleep(2000); } catch (Exception e) {}
         System.out.println("Проверка завершена.");
     }).start();
     ```

---

### Требования к коду (обязательно использовать)

| Технология | Где использовать |
|-----------|------------------|
| **Коллекции** | `ArrayList<Note>`, `HashMap<String, Note>` |
| **Lambda** | `stream().filter()`, `forEach()` |
| **Анонимный класс** | `new Runnable() { ... }` |
| **Аннотация** | `@Task` + рефлексия в `main` |
| **Файлы** | `Files.write()`, `Files.readAllLines()` |
| **Многопоточность** | `new Thread(lambda).start()` |

---

### Пример вывода

```
> 1
Введите текст: Сделать ДЗ
Заметка добавлена!

> 2
1. Сделать ДЗ | 2025-10-31T14:25

> 4
Аннотация: Сохранение заметок в файл
Сохранено в notes.txt

> 6
Напоминание: у вас 1 заметок!
(через 2 сек) Проверка завершена.
```

---

### Что сдавать  
1. Один файл `NoteManager.java`  
2. `notes.txt` (создаётся автоматически)  
3. В `main`:  
   - Автозагрузка из файла  
   - Проверка аннотации  
   - Меню в `while (true)`  

---

