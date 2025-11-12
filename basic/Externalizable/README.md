### 4) Тема: Расширенная сериализация (интерфейс Externalizable)

2) Пример:  
- Адаптация SerializeFish/DeserializeFish к Externalizable (класс FishEx с ручной записью/чтением полей name, weight, price через writeExternal/readExternal).

3) Объяснение темы:  
Externalizable предоставляет полный ручной контроль над процессом сериализации, требуя реализации методов для записи и чтения полей в поток, без автоматики Serializable. Это позволяет оптимизировать формат (например, исключать ненужные данные или добавлять логику), но обязывает default-конструктор для инициализации перед чтением. Полезно для производительных систем с кастомными требованиями, где стандартная сериализация избыточна или негибка.

4) Основные методы и особенности:  
- **writeExternal(ObjectOutput out):** Ручная последовательная запись полей (e.g., out.writeUTF(String), out.writeDouble(double)) в байтовый поток.  
- **readExternal(ObjectInput in):** Соответствующее чтение в том же порядке (e.g., field = in.readUTF()), заполняя поля после default-конструктора.  
- **ObjectOutputStream/ObjectInputStream constructors:** Обертка над базовыми потоками для Externalizable (e.g., oos.writeExternal(obj) не используется; вызывается напрямую).  
- Особенности: Нет сериализации superclass автоматически (требует явных вызовов super.writeExternal); transient игнорируется, так как все manual; default-конструктор mandatory; обработка IOException без ClassNotFoundException (поскольку нет метаданных класса); подходит для минимизации размера потока в legacy или high-performance сценариях.