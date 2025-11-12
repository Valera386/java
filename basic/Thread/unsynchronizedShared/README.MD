### 1) Тема: Race conditions при несинхронизированном доступе к общим ресурсам (unsynchronized shared resource access)

2) Примеры:  
- **Testsunchro.java:** Создание двух потоков MyThread, делящих MyResource; каждый поток добавляет числа от 0 до 100 в counter; ожидание завершения с join() и вывод финального значения.  
- **MyResource.java:** Простой класс с полем counter и методом add() для инкремента без синхронизации.

3) Объяснение темы:  
Несинхронизированный доступ к shared ресурсу (как counter) в многопоточной среде приводит к race conditions: потоки конкурируют за доступ, вызывая потерю обновлений (lost updates) или некорректные значения из-за interleaving операций. В примере ожидаемая сумма (2 * sum(0..100) = 10100), но на практике результат меньше из-за overlapping add() без atomicity. Это иллюстрирует необходимость synchronization (synchronized blocks/methods) для thread-safety, предотвращая data corruption в concurrent приложениях, таких как counters или shared data structures.

4) Основные методы и особенности:  
- **MyResource.add(long value):** Несинхронизированный инкремент (counter += value); vulnerable к race из-за compound operation (read-modify-write).  
- **Thread.start() / join():** Параллельный запуск и блокирующее ожидание; throws InterruptedException с catch для handling.  
- **MyThread.run():** Цикл for(0..100) с вызовами add(i); extends Thread для simple concurrency.  
- Особенности: Нет volatile/transient (counter не atomic); результат варьируется по runs (e.g., ~5000-10000); Logger для severe errors; fix via synchronized(add) или AtomicLong; демонстрирует why use java.util.concurrent для production.