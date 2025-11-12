### 1) Тема: Реализация задач через интерфейс Runnable (альтернатива наследованию от Thread)

2) Примеры:  
- **MainForRunnable.java:** Создание потоков на основе Runnable-объектов, установка daemon-режима, запуск и блокирующее ожидание с join().  
- **MyThread3.java:** Класс, реализующий Runnable, с логикой decrement'а значения, печатью прогресса и sleep() в методе run().

3) Объяснение темы:  
Интерфейс Runnable определяет контракт для задач (run()), которые могут выполняться в потоке, без необходимости наследовать от Thread. Это позволяет классу расширять другие (multiple inheritance workaround в Java) и фокусироваться на бизнес-логике, передавая экземпляр в конструктор Thread. В примере daemon-потоки с join() обеспечивают параллельное выполнение с ожиданием завершения, аналогично предыдущим примерам, но с лучшей decoupling: Thread управляет lifecycle, Runnable — задачей. Полезно для reusable задач в пулах потоков (ExecutorService).

4) Основные методы и особенности:  
- **Thread(Runnable target):** Конструктор для создания потока из Runnable; target.run() вызывается в start().  
- **Runnable.run():** Переопределение для логики задачи (в MyThread3: цикл while с print, decrement и sleep(300ms)).  
- **Thread.start() / join():** Запуск и блокирующее ожидание; throws InterruptedException для обработки прерываний.  
- Особенности: Daemon via setDaemon(true) до start(); sleep() в run() симулирует работу с catch InterruptedException (игнор здесь); Random для вариабельной длительности; output interleaves; предпочтительнее extends Thread для composition over inheritance; интегрируется с Future/Callable для advanced concurrency.