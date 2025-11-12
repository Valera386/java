### 3) Тема: Сериализация объектов (интерфейс Serializable)

2) Примеры:  
- **SerializeFish.java:** Сохранение объекта Fish в файл через ObjectOutputStream.  
- **DeserializeFish.java:** Восстановление объекта из файла через ObjectInputStream.

3) Объяснение темы:  
Сериализация преобразует состояние объекта в последовательность байтов для хранения в файле, сети или памяти, позволяя восстановить его позже с сохранением типа и значений полей. Интерфейс Serializable обеспечивает автоматическую обработку JVM для eligible классов, фокусируясь на non-static и non-transient полях. Это ключевой механизм для persistence в приложениях, где объекты нужно сохранять между запусками или передавать, обходя ограничения статических структур данных.

4) Основные методы и особенности:  
- **ObjectOutputStream.writeObject(Object obj):** Автоматическая сериализация объекта и его граф (включая ссылки), с записью метаданных класса.  
- **ObjectInputStream.readObject():** Десериализация с возвратом объекта; требует явного cast к типу, проверяя совместимость.  
- **defaultReadObject() / defaultWriteObject():** Вызовы внутри read/writeObject для сериализации полей (используется implicitly в Serializable).  
- Особенности: serialVersionUID для контроля версий (явно объявить для избежания InvalidClassException); transient поля исключаются; обработка NotSerializableException и ClassNotFoundException; поддержка custom writeObject/readObject для overrides.