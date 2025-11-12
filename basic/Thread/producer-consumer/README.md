### 1) Тема: Межпоточная коммуникация с wait() и notify() (producer-consumer pattern)

2) Примеры:  
- **SynchroWaitNotify.java:** Координация MyReader (читает строки из lines.txt) и MyWriter (записывает в lines_out.txt) через shared locker; reader пропускает каждую вторую строку, notify/wait для чередования; daemon threads с initial sleep и join.

3) Объяснение темы:  
Wait() и notify() в synchronized блоках позволяют потокам обмениваться сигналами: producer (reader) заполняет данные и notify(), consumer (writer) ждет на wait() до сигнала, затем обрабатывает и notify() обратно. Это реализует базовый producer-consumer без очередей, обеспечивая порядок (чередование строк) и предотвращая busy-wait. В примере reader обрабатывает четные строки, writer — все, с "exit" для graceful завершения; требует shared lock для mutual exclusion и signaling.

4) Основные методы и особенности:  
- **synchronized(locker) { ... notify(); wait(); }:** Acquire lock, signal (notify() будит waiting thread) и release с wait() (освобождает lock и suspends current thread).  
- **Object.wait() / notify():** Wait() throws InterruptedException; notify() будит arbitrary waiting thread (notifyAll() для всех); вызывать только в synchronized.  
- **Thread.sleep(long) / join():** Initial delay для sequencing; join() для ожидания daemon'ов; catch InterruptedException с logging.  
- Особенности: Risk spurious wakeups (retry condition check); no built-in queue (manual line sharing); file I/O (BufferedReader/FileWriter) с finally close; daemon для auto-terminate; scale с BlockingQueue для complex patterns.

### 2) Тема: Ограничение concurrency с Semaphore (resource pooling)

2) Примеры:  
- **SemaphoreAnonymous.java:** Анонимный Runnable с Semaphore(5); 20 threads, каждый acquire, random sleep(500-2500ms), release.  
- **MySemaphore.java:** Runnable класс с Semaphore(5) и counter в конструкторе; run() с acquire, print, sleep(counter), release.  
- **SemaphoreMain.java:** Main создает 20 MySemaphore с random counter (1000-3000ms) и запускает threads.

3) Объяснение темы:  
Semaphore управляет доступом к fixed ресурсам (permits=5), позволяя max N потоков одновременно: acquire() decrements (blocks если 0), release() increments. Это throttling concurrency, e.g., для DB connections или API limits, без full exclusion (как mutex). В примерах 20 threads, но только 5 concurrent работают (sleep симулирует load), остальные queue; anonymous для inline, class-based для reusable.

4) Основные методы и особенности:  
- **Semaphore.acquire() / release():** Acquire() blocks until permit available (throws InterruptedException); release() frees one, waking waiter.  
- **Semaphore(int permits):** Constructor с initial count (5 для 5 slots); fair=true для FIFO queuing.  
- **Thread.sleep(long):** В run() для workload simulation; catch InterruptedException с logging.  
- Особенности: Non-fair by default (barging possible); tryAcquire() для non-blocking; availablePermits() для monitoring; Random для variable duration; no shared state beyond semaphore; prefer Executors.newFixedThreadPool() для simpler pooling.