### 1) Тема: Stream API — Фильтрация и преобразование строк (filter и map для простых коллекций)

2) Примеры:  
- **StreamFilterCountriesU.java:** Создание Stream из массива стран, фильтрация по startsWith("U") и вывод результатов.  
- **StreamCountriesUpperCase.java:** Stream из стран с map для преобразования в верхний регистр и вывод.

3) Объяснение темы:  
Stream API позволяет обрабатывать последовательности данных декларативно: filter отбирает элементы по предикату, map преобразует их (например, строки в uppercase). Это функциональный подход, ленивый (операции не выполняются до терминального метода вроде forEach), эффективный для immutable данных. В примерах демонстрируется базовая цепочка для строк, выводя "Ukraine" и "USA" (фильтр) или все в UPPERCASE, подчеркивая читаемость кода без циклов.

4) Основные методы и особенности:  
- **Stream.of(...).filter(Predicate):** Отбор элементов (e.g., c.startsWith("U")); lambda или method reference; intermediate operation.  
- **map(Function):** Преобразование (e.g., String::toUpperCase); возвращает новый Stream с трансформированными данными.  
- **forEach(Consumer):** Терминальный метод для side-effects (print); выполняет цепочку.  
- Особенности: Ленивая оценка (нет compute до forEach); parallelStream() для concurrency; immutable source;Collectors для агрегации; подходит для простых трансформаций, но watch memory для large streams.

**Проверка работы:** Оба примера компилируются и выполняются без ошибок в Java 8+. Вывод StreamFilterCountriesU: Ukraine\nUSA. Вывод StreamCountriesUpperCase: ARGENTINA\nBULGARIA\nCANADA\nDENMARK\nUKRAINE\nUSA (каждое в новой строке). Нет зависимостей от внешних классов.

### 2) Тема: Сортировка списков объектов с Comparator (Collections.sort)

2) Примеры:  
- **SortFishesByWeight.java:** Создание List<Fish>, добавление объектов, сортировка по весу с anonymous Comparator и вывод до/после.

3) Объяснение темы:  
Collections.sort сортирует List in-place по естественному порядку или custom Comparator, сравнивающему объекты (e.g., по double weight с cast to int для precision). Это мутабельная операция, стабильная (сохраняет относительный порядок equal элементов). В примере рыбы сортируются по весу (eel 1.5, salmon 2.5 и т.д.), иллюстрируя кастомное сравнение для бизнес-логики, как ranking или ordering в отчетах.

4) Основные методы и особенности:  
- **Collections.sort(List, Comparator):** In-place sort; Comparator.compare(o1, o2) возвращает negative/0/positive для < = >.  
- **Comparator.compare(Fish f1, Fish f2):** Lambda или anonymous (e.g., (int)(f1.getWeight()*100 - f2.getWeight()*100) для decimal handling).  
- **Fish.getWeight():** Getter для доступа к полю; toString() для print.  
- Особенности: Stable sort (O(n log n)); requires Comparable or Comparator; precision loss в cast (use Double.compare для safety); pre-Java 8: anonymous class; post: Comparator.comparing(Fish::getWeight).

**Проверка работы:** Пример компилируется при наличии класса Fish (с полями name, weight, price; методами getWeight(), toString() — как в предыдущих примерах из истории). Выполняется без ошибок: вывод "Before" — в порядке добавления, "After" — отсортировано по весу (eel, salmon, trout, carp, tuna). Если Fish отсутствует, ошибка компиляции: cannot find symbol. Рекомендация: добавить класс Fish для standalone.

### 3) Тема: Stream API для объектов — Фильтрация и агрегация (filter, collect, count, sum)

2) Примеры:  
- **StreamFilterFishes.java:** Stream из List<Fish>, фильтрация по цене >100, collect в новый List и вывод.  
- **StreamCountAndSumFishes.java:** Два отдельных stream: count() для количества Fish >100, mapToDouble + sum() для общей цены.

3) Объяснение темы:  
Streams на объектах сочетают filter для отбора (по условию как price >100) с терминальными операциями: collect для нового контейнера, count для размера, sum для агрегации. Это функциональный эквивалент циклов, parallel-friendly. В примерах отбираются дорогие рыбы (salmon, tuna, trout), подсчитывается 3 шт. и сумма 650, демонстрируя efficiency для querying без mutable state changes.

4) Основные методы и особенности:  
- **stream().filter(Predicate):** Отбор (f -> f.getPrice() > 100); intermediate.  
- **collect(Collectors.toList()):** Терминальный, builds List из Stream.  
- **count():** Long для количества после filter; terminal, consumes Stream.  
- **mapToDouble(ToDoubleFunction).sum():** Преобразование в DoubleStream, sum() для aggregate; terminal.  
- Особенности: Separate streams для разных ops (no reuse); parallel() для speed-up; Fish getters/toString(); reduce() alternative для custom sum; memory-efficient для large lists.

**Проверка работы:** Компилируется с классом Fish (getPrice(), toString()). Выполняется OK: StreamFilterFishes выводит salmon, tuna, trout (каждый в строке). StreamCountAndSumFishes: number=3 total cost=650.0. Без Fish — ошибка компиляции. Доработка: добавить import java.util.*; для ArrayList/List.

### 4) Тема: Stream API — Преобразование числовых коллекций (map для вычислений)

2) Примеры:  
- **StreamMapSquares.java:** List<Integer>, map для квадрата каждого (i * i), collect в новый List и вывод.

3) Объяснение темы:  
Map на числовых streams трансформирует элементы (e.g., square), возвращая новый Stream для chaining. Это declarative math, avoiding imperative loops. Пример вычисляет квадраты (121, 25, 14400 и т.д.), полезно для data processing как scaling или derivations в analytics.

4) Основные методы и особенности:  
- **stream().map(IntUnaryOperator):** Lambda (i -> i * i); intermediate для IntStream.  
- **collect(Collectors.toList()):** Builds List<Integer> из transformed Stream.  
- **forEach(Consumer):** Print для visualization; terminal.  
- Особенности: Auto-boxing/unboxing; primitive streams (IntStream) для perf; flatMap для nested; Random-like data для testing; integrate с Arrays для sources.

**Проверка работы:** Компилируется и выполняется без ошибок (import java.util.*; уже есть). Вывод: Squares:\n121\n25\n14400\n7225\n63001\n39601 (каждый в строке). Полностью standalone.

### 5) Тема: Сериализация коллекций объектов (сериализация List)

2) Примеры:  
- **SerializeMultiple.java:** Создание List<Fish>, добавление объектов и вызов serialize(fishes, "fishes.txt") (метод как в предыдущих примерах).

3) Объяснение темы:  
Сериализация коллекций (List<Fish>) сохраняет весь набор объектов в поток (файл), используя ObjectOutputStream для recursive сериализации элементов, если класс Serializable. Это extends single-object сериализацию, сохраняя структуру (size, order). Пример сериализует несколько Fish, позволяя persistent storage коллекций для later deserialize, как в databases или configs.

4) Основные методы и особенности:  
- **ObjectOutputStream.writeObject(List):** Авто-сериализация коллекции и элементов (requires Fish implements Serializable).  
- **ArrayList.add(Fish):** Build-up списка перед serialize.  
- **serialize(List, String filename):** Custom метод (e.g., new ObjectOutputStream(new FileOutputStream(file)).writeObject(list)).  
- Особенности: Preserves iteration order; transient ignored in elements; serialVersionUID для multi-object consistency; IOException handling; deserialize via readObject() to List.

**Проверка работы:** Неполный: метод serialize() закомментирован ("// serialize method as above"), так что компиляция OK, но выполнение — NoSuchMethodError или runtime error без реализации. С добавлением метода (как в SerializeFish.java: try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));) { oos.writeObject(list); }) — работает, создает fishes.txt. Требует Fish implements Serializable. Доработка: реализовать метод.

### 6) Тема: Перенаправление стандартных потоков ввода-вывода (System.in/out)

2) Примеры:  
- **SystemOutRedirect.java:** Set System.out к PrintStream на FileOutputStream("out.txt"), print тестового сообщения.  
- **SystemInReadLine.java:** BufferedReader на System.in, readLine() для ввода строки.

3) Объяснение темы:  
System.in/out — глобальные потоки; redirect out перенаправляет print в файл (для logging/capture), readLine от in — для interactive input. Это low-level I/O control, полезно в testing (mock input) или batch processing. Примеры: out.txt получает "The output is redirected...", readLine ждет user input.

4) Основные методы и особенности:  
- **System.setOut(PrintStream):** Redirect stdout; new PrintStream(FileOutputStream) для file.  
- **BufferedReader.readLine():** Reads до \n; throws IOException; null at EOF.  
- **InputStreamReader(System.in):** Bridge bytes to chars; UTF-8 default.  
- Особенности: setErr() аналогично для stderr; try-catch для FileNotFound; close() streams; non-blocking readLine в loops; security manager может block redirect.

**Проверка работы:** SystemOutRedirect: компилируется, выполняется — создает out.txt с "The output is redirected into file now!", catch Exception на ошибках (e.g., no write permission). SystemInReadLine: компилируется, но readLine() blocks до ввода; throws IOException (handled). Standalone, OK.

### 7) Тема: Простые методы для объектов (accessor/utility methods)

2) Примеры:  
- **ShowGroupMethod.java:** Static метод showGroup(Group), вызывающий group.bestAlbum() и print.

3) Объяснение темы:  
Utility методы (как showGroup) инкапсулируют доступ к объектам, delegating to instance methods (bestAlbum()). Это promotes single responsibility, reusable для display или processing. Пример — фрагмент для Group (возможно, с Albums), printing best album name.

4) Основные методы и особенности:  
- **public static void showGroup(Group g):** Takes param, calls g.bestAlbum() (String return assumed).  
- **System.out.println:** Side-effect для output.  
- **Group.bestAlbum():** Instance method; toString() implicit.  
- Особенности: Static для utils (no instance needed); overload для variants; integrate с streams (e.g., groups.stream().forEach(ShowGroupMethod::showGroup)); null-check g to avoid NPE.

**Проверка работы:** Неполный фрагмент: компиляция требует класса Group с методом bestAlbum() (String). Без него — cannot find symbol. Выполнение: если Group добавлен (e.g., class Group { public String bestAlbum() { return "AlbumX"; } }), выводит AlbumX. Доработка: добавить класс Group для теста.

### 1) Тема: Функциональные интерфейсы Predicate для фильтрации объектов (lambda-предикаты в коллекциях)

2) Примеры:  
- **PredicateFishesExpensive.java:** Фильтрация рыб по цене >200 с использованием GetByPredicate и lambda.  
- **PredicateFishesLongNames.java:** Фильтрация рыб по длине имени >5 символов.  
- **PredicateFishesHeavyAndExpensive.java:** Комбинированная фильтрация по цене >100 и весу >2.

3) Объяснение темы:  
Predicate — функциональный интерфейс для тестовых условий (test(T) -> boolean), позволяющий передавать lambda как параметр для динамической фильтрации коллекций. Это способствует reusable коду: метод GetByPredicate применяет предикат к List<Fish>, отбирая matching элементы без if-ветвлений в main. В примерах отбираются tuna (expensive), salmon/tuna (long names), salmon/tuna/trout (heavy&expensive), демонстрируя composability (&& для multiple условий) и функциональный стиль без мутации.

4) Основные методы и особенности:  
- **Predicate.test(T t):** Вызов в GetByPredicate (e.g., f.getPrice() > 200); возвращает boolean для inclusion.  
- **GetByPredicate.getByPredicate(List, Predicate):** Custom метод (предполагается: stream().filter(p).forEach(print)); применяет предикат.  
- **f.getPrice() / getName() / getWeight():** Getters для доступа к полям Fish; length() для String.  
- Особенности: Lambda composable (&&/||); stateless (no side-effects); parallelStream() compatible; requires Fish class; output via print (assumed in GetByPredicate); alternative: removeIf() для in-place filter.

**Проверка работы:** Компилируется с классом Fish (поля name/weight/price, getters, toString()) и GetByPredicate (e.g., public static void getByPredicate(List<Fish> l, Predicate<Fish> p) { l.stream().filter(p).forEach(System.out::println); }). Выполняется OK: Expensive — tuna; LongNames — salmon, trout; Heavy&Expensive — salmon, tuna, trout. Без зависимостей — ошибка компиляции. Standalone с добавлением классов.

### 2) Тема: Лямбда-выражения для сортировки коллекций (List.sort с Comparator)

2) Примеры:  
- **LambdaSortFishesByWeight.java:** Сортировка List<Fish> по весу с lambda-Comparator и вывод до/после.

3) Объяснение темы:  
List.sort() с lambda Comparator предоставляет concise кастомную сортировку in-place, заменяя anonymous classes. Lambda (f1, f2) -> compare возвращает int для ordering, handling decimals via scaling (*100). Это функциональный upgrade Collections.sort, stable и efficient (O(n log n)). Пример сортирует eel(1.5) -> salmon(2.5) -> trout(2.8) -> carp(3.5) -> tuna(4.2), полезно для data ordering в UI или reports.

4) Основные методы и особенности:  
- **List.sort(Comparator):** In-place; lambda as Comparator (e.g., (f1, f2) -> (int)(f1.getWeight()*100 - f2.getWeight()*100)).  
- **Comparator.compare(T o1, T o2):** Negative/0/positive для < = >; scaling для double precision.  
- **Fish.getWeight():** Getter; toString() для print в for-each.  
- Особенности: Stable (preserves equals order); pre-Java8: Collections.sort; use Double.compare(f1.getWeight(), f2.getWeight()) для safety; ascending default, negate для descending; no external deps beyond Fish.

**Проверка работы:** Компилируется с Fish (getWeight(), toString()). Выполняется без ошибок: "Before" — add order, "After" — sorted by weight. Полностью standalone с Fish; вывод соответствует ожиданиям.

### 3) Тема: Байтовый ввод-вывод файлов (низкоуровневое чтение/запись с условием)

2) Примеры:  
- **ReadWriteByteByByte.java:** Чтение "test.txt" байт за байтом, запись в "outputFile3.txt" если <65 (A=65).

3) Объяснение темы:  
FileInputStream/OutputStream для byte-oriented I/O: read() возвращает int (-1 at EOF), write(int) для output. Условная фильтрация (c < 65) демонстрирует processing на лету, полезно для text filtering или binary manipulation без буферов. Try-catch-finally обеспечивает resource management; создает output с символами ниже 'A' (e.g., numbers, punctuation).

4) Основные методы и особенности:  
- **FileInputStream.read():** Чтение одного байта как int; loop while != -1 для full file.  
- **FileOutputStream.write(int b):** Запись байта; conditional (if c < 65).  
- **finally { in.close(); out.close(); }:** Cleanup; catch IOException для errors.  
- Особенности: Low-level (no charset handling, assumes ASCII); inefficient для large files (no buffer); requires "test.txt" existence; FileNotFoundException если no perms; use Buffered для speed; outputFile3.txt created/overwritten.

**Проверка работы:** Компилируется без ошибок. Выполняется: если "test.txt" существует (e.g., с текстом "ABC123"), создает outputFile3.txt с "123" (байты <65). Без файла — FileNotFoundException (stack trace). Standalone, но зависит от input file.

### 4) Тема: Сериализация объектов (Serializable vs Externalizable)

2) Примеры:  
- **SerializeFish.java:** Сериализация Fish в "fish.txt" через ObjectOutputStream.writeObject().  
- **SerializeFishEx.java:** Сериализация FishEx в "fishex.txt" через writeExternal().

3) Объяснение темы:  
Serializable — автоматическая сериализация (writeObject сохраняет поля), Externalizable — manual (writeExternal для custom format, e.g., selective fields). Оба используют ObjectOutputStream на FileOutputStream для persistence. Примеры сериализуют salmon (name, weight, price), с Externalizable для control (e.g., skip transients). Полезно для saving state в файлы или сеть, с finally для close.

4) Основные методы и особенности:  
- **ObjectOutputStream.writeObject(Object):** Авто для Serializable (Fish implements).  
- **obj.writeExternal(ObjectOutput):** Manual для Externalizable (FishEx: out.writeUTF(name); etc.).  
- **FileOutputStream / ObjectOutputStream constructors:** Chain для file output; flush implicit.  
- Особенности: Requires implements Serializable/Externalizable; IOException handling; default ctor для Externalizable; serialVersionUID recommended; files created; deserialize counterpart needed; no print, just save.

**Проверка работы:** Компилируется с Fish/FishEx (implements Serializable/Externalizable, fields/getters). Выполняется: создает fish.txt/fishex.txt с serialized data. Без классов — cannot find symbol. Standalone с добавлением классов; no output to console, check files via hex editor или deserialize.

### 5) Тема: Многопоточное чтение/запись в общую коллекцию (Reader-Writer threads)

2) Примеры:  
- **MyWriter.java:** Thread, добавляющий "elementN" в List каждую секунду (infinite loop).  
- **MyReader.java:** Thread, итерирующий List, printing elements с sleep(10ms) (infinite).

3) Объяснение темы:  
Extends Thread для concurrent access: Writer производит (add), Reader потребляет (iterator/print). Без sync — race conditions (ConcurrentModificationException при iterate во время add). Infinite loops с sleep симулируют ongoing work; setName для ID. Полезно для basic producer-consumer, но требует synchronization (e.g., synchronized(list)) для safety.

4) Основные методы и особенности:  
- **Thread.run():** Infinite while(true); add(String) в Writer, iterator.hasNext()/next() в Reader.  
- **Thread.sleep(long):** Delay (1000ms Writer, 10ms Reader); catch InterruptedException.  
- **List.add() / Iterator:** Writer modifies, Reader traverses (risk CME).  
- Особенности: No join/daemon — runs forever; super.getName() для logging; cast to String; shared List param; output interleaves; add synchronized или CopyOnWriteArrayList для fix; InterruptedException print.

**Проверка работы:** Компилируется без ошибок. Выполняется: Writer добавляет elements, Reader prints growing list (e.g., "MyReader: element0 element1..."), но eventual ConcurrentModificationException из-за unsync access. Standalone, но hangs (kill via Ctrl+C); add sync для stability.

### 6) Тема: Определение сущностей в ORM (аннотации для persistence)

2) Примеры:  
- **PictureAnnotatedClass.java:** @Entity класс Picture с @PrimaryKey, @Persistent, @Getter/@Setter.

3) Объяснение темы:  
JPA/JDO annotations (@Entity, @PrimaryKey, @Persistent) маркируют класс для ORM: mapping полей к БД (pictureId PK, pictureName persistent). Lombok-like @Getter/@Setter генерируют accessors; @Optional для nullable setter. Это metadata для persistence frameworks, enabling auto-CRUD без boilerplate.

4) Основные методы и особенности:  
- **@Entity / @PrimaryKey / @Persistent:** Annotations для class/field (Integer pictureId, String pictureName).  
- **@Getter public String getPictureName():** Auto-generated getter.  
- **@Setter void setPictureName(@Optional String):** Setter с optional param (nullable).  
- Особенности: Requires imports (javax.persistence.* или lombok.*); incomplete snippet (missing package/class body); runtime via EntityManager; @Optional from validation; use for JPA entities; compile OK с libs, но runtime needs framework.

**Проверка работы:** Неполный: компиляция требует imports (import javax.jdo.annotations.*; или lombok) и full class (public class). Без — syntax errors. С добавлением — compiles, но no main (utility class). Не executable standalone; test via JPA setup.

### 1) Тема: Управление файлами и директориями (File и Directory operations)

2) Примеры:  
- **FileCreateExample.java:** Создание файла "test.txt" в текущей директории, если он не существует.  
- **DirectoryCreateExample.java:** Создание многоуровневой директории "tmp/user/java/bin" в текущей директории.

3) Объяснение темы:  
Класс File позволяет манипулировать filesystem: createNewFile() для новых файлов с проверкой exists(), mkdirs() для создания цепочки директорий (включая родительские). Это базовые операции для setup storage в приложениях, с handling путей via user.dir и separator. В примерах fullName строится динамически, выводя путь; mkdirs() succeeds если path valid, иначе false (no exception).

4) Основные методы и особенности:  
- **File.createNewFile():** Создает пустой файл; returns true on success, throws IOException на errors (e.g., no perms).  
- **File.mkdirs():** Создает директории recursively; returns true если created или exists.  
- **File.exists():** Boolean check перед create; System.getProperty("user.dir") для base path.  
- Особенности: Atomic createNewFile (no race); separator cross-platform; IOException catch; no content write; check via ls в dir после run; fails если root-only access.

**Проверка работы:** Оба компилируются без ошибок (standalone). FileCreateExample: выполняется OK, создает "test.txt" (0 bytes), вывод "File created!" если new. DirectoryCreateExample: создает nested dirs, no output (add print(d.mkdirs()) для "Directories created!"). Зависит от write perms; на read-only — IOException (stack trace).

### 2) Тема: Символьный ввод-вывод с обработкой текста (BufferedReader/Writer для фильтрации строк)

2) Примеры:  
- **FileReaderWriterOddLines.java:** Чтение "lines.txt", копирование четных строк (0-based) в "lines1.txt" с print.  
- **FileReaderWriterReplaceE.java:** Чтение "lines.txt", замена 'e' на 'E' в четных строках, запись в "lines1.txt" с print.

3) Объяснение темы:  
FileReader/Writer + BufferedReader для char-oriented I/O: readLine() для строк, write() для output с line.separator. Conditional processing (lineCounter % 2 == 0) демонстрирует selective copy/transform, полезно для log parsing или data cleaning. Try-catch-finally обеспечивает close; append=true в Writer для non-overwrite (но здесь overwrites если exists).

4) Основные методы и особенности:  
- **BufferedReader.readLine():** Читает до \n; null at EOF; loop while != null.  
- **FileWriter.write(String/ char[]):** Запись строки или buffer; getChars() для char[] в ReplaceE.  
- **lineCounter % 2 == 0:** Even-line filter; fw.write(System.getProperty("line.separator")) для \n.  
- Особенности: Charset default (UTF-8); buffer in ReplaceE для manual char loop (if 'e' -> 'E'); requires "lines.txt"; output appends if true; finally close prevents leaks; inefficient для huge files (load all).

**Проверка работы:** Компилируются standalone. Выполняются: если "lines.txt" exists (e.g., "Line1\neLine2\nLine3"), OddLines: prints/writes Line1, Line3; ReplaceE: prints Line1, writes "LinE1\n" (e=0), skips odd. Без файла — FileNotFoundException. Standalone, но зависит от input; create sample lines.txt для full test.

### 3) Тема: Копирование бинарных файлов с try-with-resources (InputStream/OutputStream)

2) Примеры:  
- **CopyFileWithResources.java:** Копирование "1.jpg" в "outputFile2.tmp" via byte buffer с available().

3) Объяснение темы:  
Try-with-resources auto-closes streams, preventing leaks: FileInputStream/OutputStream для bytes, read(buffer) / write(buffer) для full copy. available() sizes buffer (inefficient для streams, но simple); полезно для image/file backup, с catch для errors.

4) Основные методы и особенности:  
- **try (InputStream in = ...; OutputStream out = ...):** Auto-close; in.available() для buffer size.  
- **in.read(byte[] buffer):** Reads into array; full file via single call (assumes small).  
- **out.write(byte[]):** Writes buffer; no flush needed (implicit on close).  
- Особенности: Byte-oriented (binary safe); available() not reliable (0 possible); IOException on no file/perms; creates outputFile2.tmp; add loop для large files (while((len=in.read())>0) out.write(buffer,0,len)).

**Проверка работы:** Компилируется standalone. Выполняется: если "1.jpg" exists, копирует в "outputFile2.tmp" (same size), no output. Без "1.jpg" — FileNotFoundException. Standalone; verify via file size diff.

### 4) Тема: Десериализация объектов (ObjectInputStream для Serializable/Externalizable)

2) Примеры:  
- **DeserializeFish.java:** Десериализация Fish из "fish.txt" via readObject().  
- **DeserializeFishEx.java:** Десериализация FishEx из "fishex.txt" via readExternal().

3) Объяснение темы:  
ObjectInputStream восстанавливает объекты из байтов: readObject() для Serializable (auto-fields), readExternal() для Externalizable (manual). Cast to type, print via toString(); catch ClassNotFound для mismatch. Зеркало сериализации, для loading saved state (e.g., config restore).

4) Основные методы и особенности:  
- **ObjectInputStream.readObject():** Returns Object (cast to Fish); auto-deserializes fields.  
- **obj.readExternal(ObjectInput):** Manual для Externalizable (fills via in.readUTF() etc.); new FishEx() first.  
- **FileInputStream / ObjectInputStream:** Chain; close in finally.  
- Особенности: Requires matching serialVersionUID; ClassNotFoundException если class changed; IOException on corrupt file; no file — FileNotFound; print f/fe после; depends on prior serialize.

**Проверка работы:** Компилируются с Fish/FishEx (implements Serializable/Externalizable, constructors, toString()). Выполняются: если "fish.txt"/"fishex.txt" from serialize, вывод "salmon weight:2.5 price:180". Без файлов — FileNotFound. Standalone с классами; test pair with SerializeFish.

### 5) Тема: Thread-safe коллекции для многопоточности (CopyOnWriteArrayList)

2) Примеры:  
- **CopyOnWriteArrayListExample.java:** Инициализация COWAL с countries, запуск MyWriter (add) и MyReader (iterate/print).

3) Объяснение темы:  
CopyOnWriteArrayList — concurrent List: add() creates snapshot copy on mutate, iterators safe (no CME). Идеально для read-heavy (multiple readers, rare writes); Writer adds "elementN", Reader iterates/print без crash. Extends Thread, shared list; runs infinite до stop.

4) Основные методы и особенности:  
- **CopyOnWriteArrayList.add(Object):** Thread-safe mutate (copy-on-write).  
- **Iterator.hasNext() / next():** Snapshot-iterator, ignores concurrent adds (no CME).  
- **Thread.start():** Запуск Writer/Reader; no join — infinite.  
- Особенности: High read perf, costly writes (copy O(n)); initial add safe; depends on MyWriter/MyReader (from prev: add/sleep, iterate/sleep/print); output grows ("MyReader: Belgium USA ... element0 element1"); Ctrl+C to stop.

**Проверка работы:** Компилируется с MyWriter/MyReader (extends Thread, run() с add/iterate). Выполняется: adds countries, Writer appends elements/sec, Reader prints list periodically (growing, no crash). Standalone с threads; runs forever, memory grows on adds.

### 6) Тема: Простые классы для хранения данных (POJOs с полями и методами)

2) Примеры:  
- **CountryInfo.java:** Класс с country/capital (комментарии для constructors/getters/setters).  
- **Fish.java:** Полный POJO с name/weight/price, constructor, getters/setter, toString().

3) Объяснение темы:  
POJOs (Plain Old Java Objects) — simple data holders: private fields, public accessors (get/set), constructor для init, toString() для print. Базовые для models в apps (e.g., DTOs); CountryInfo — skeleton, Fish — full (used in streams/serialize).

4) Основные методы и особенности:  
- **Constructor(String, double, double):** Init fields (Fish); no-arg default.  
- **getName() / getWeight() / getPrice() / setPrice():** Accessors; return types match.  
- **@Override toString():** Custom string rep (e.g., "name weight:X price:Y").  
- Особенности: Immutable potential (no setters); equals/hashCode add for collections; Lombok alternative для boilerplate; CountryInfo incomplete (add impl); used in prev examples (streams, serialize).

**Проверка работы:** Fish компилируется/используется standalone (no main, utility). CountryInfo: компиляция OK как skeleton; add main/print для test (e.g., new CountryInfo("USA","Washington").toString()). No runtime issues; extend для full use.

### 1) Тема: Буферизованные потоки для чтения и записи файлов (BufferedInputStream/OutputStream и Reader/Writer)

2) Примеры:  
- **BufferedReadExample.java:** Чтение "notes.txt" байт за байтом с BufferedInputStream и вывод в консоль как char.  
- **BufferedWriteExample.java:** Запись строки в "notes.txt" через BufferedOutputStream с буфером.  
- **BufferedReaderWriterLines.java:** Копирование строк из "lines.txt" в "lines2.txt" с указанием кодировок (windows-1251 -> UTF-8), печать строк.

3) Объяснение темы:  
Буферизованные потоки (Buffered*) оборачивают базовые (FileInput/OutputStream, Reader/Writer), накапливая данные в буфере для снижения I/O-вызовов, ускоряя операции на файлах. Для байтов — read/write(int/char), для символов — readLine()/write(String) с encoding support. Try-with-resources auto-closes; полезно для text/binary processing, как log reading или file duplication, с conditional output (print lines).

4) Основные методы и особенности:  
- **BufferedInputStream.read():** Чтение байта как int (-1 at EOF); loop while для full file, cast to char для print.  
- **BufferedOutputStream.write(byte[], off, len):** Запись буфера (text.getBytes()); flush implicit on close.  
- **BufferedReader.readLine():** Строка до \n; BufferedWriter.write(String + line.separator) для output с encoding (e.g., "windows-1251").  
- Особенности: Default buffer 8192 bytes; charset in Reader/Writer prevents garble (e.g., Cyrillic); IOException catch; requires input files; Reader/Writer char-safe, streams byte-oriented.

**Проверка работы:** Все компилируются standalone (import java.io.*;). BufferedRead: выполняется если "notes.txt" exists, prints content (e.g., "Hello" -> H e l l o); без — FileNotFound (message). BufferedWrite: создает/перезаписывает "notes.txt" с text, no console output. BufferedReaderWriter: копирует "lines.txt" в "lines2.txt" (UTF-8), prints lines; без input — FileNotFound. Standalone, но зависит от files; test с sample text.

### 2) Тема: Потоки в памяти на основе байтовых массивов (ByteArrayInput/OutputStream для обработки данных)

2) Примеры:  
- **ByteArrayInputStreamString.java:** Преобразование строки в ByteArrayInputStream, чтение и капитализация символов в StringBuilder.  
- **ByteArrayOutputStreamImage.java:** Загрузка "2.jpg" в BufferedImage, запись в ByteArrayOutputStream как JPG, создание ImageFrame из байтов.

3) Объяснение темы:  
ByteArray*Stream работают с in-memory байтами как с потоком: InputStream для чтения (e.g., string.getBytes()), OutputStream для записи/преобразования (toByteArray()). Нет I/O, идеально для transform (capitalize) или serialization (image to bytes для GUI/network). В примерах: текст -> uppercase, image -> bytes -> frame; throws IOException в main для ImageIO.

4) Основные методы и особенности:  
- **ByteArrayInputStream.read():** Чтение байта (int); loop с Character.toUpperCase((char)ch) для StringBuilder.append().  
- **ByteArrayOutputStream.write(image, format):** Via ImageIO.write(BufferedImage, "jpg", baos); toByteArray() для извлечения.  
- **ImageIO.read(File):** Загрузка изображения; new ImageFrame(byte[]) для display (assumes class exists).  
- Особенности: getBytes() default UTF-8; no close needed (memory); IOException on image errors; StringBuilder efficient для build; depends on "2.jpg"/ImageFrame; output "THIS IS A SAMPLE STRING TO BE CAPITALIZED".

**Проверка работы:** ByteArrayInputStreamString: компилируется/выполняется standalone, вывод "Capitalized string: THIS IS A SAMPLE STRING TO BE CAPITALIZED". ByteArrayOutputStreamImage: компилируется с javax.imageio.* и java.awt.*, выполняется если "2.jpg" exists и ImageFrame defined (e.g., from prev examples: JFrame with paint), opens window; без — IOException (thrown). Standalone с deps.

### 3) Тема: Копирование файлов (простое и чанковое с Input/OutputStream)

2) Примеры:  
- **CopyFileExample1.java:** Полное копирование "test.txt" в "outputFile.tmp" via available() для buffer size.  
- **CopyFileChunked.java:** Чанковое копирование "2.jpg" в "outputFile2.tmp" с 8KB буфером в loop.

3) Объяснение темы:  
FileInput/OutputStream для binary copy: single read/write для small files (available()), или chunked (fixed buffer, read/write(len)) для large/efficient. Finally close resources; try-catch для errors. Полезно для backup/transfer, chunked avoids OOM на big files (e.g., images).

4) Основные методы и особенности:  
- **in.available():** Buffer size (int bytes); in.read(buffer) full read, out.write(buffer).  
- **in.read(buffer):** Returns bytes read (-1 EOF); in chunked: while loop, out.write(buffer, 0, bytesRead).  
- **FileOutputStream.write(byte[]):** Full buffer; implicit flush on close.  
- Особенности: available() not always accurate (use 0 for unknown); chunked scalable (8*1024=8KB); IOException on no perms/file; creates output*.tmp; binary-safe; no progress log.

**Проверка работы:** Оба компилируются standalone. CopyFileExample1: копирует "test.txt" (if exists) в "outputFile.tmp" (same content/size), no output; без input — FileNotFound. CopyFileChunked: chunked copy "2.jpg" (if exists) в "outputFile2.tmp", works for large files; без — FileNotFound. Standalone, verify via diff sizes.

### 4) Тема: Анонимные внутренние классы (anonymous inner classes для overrides)

2) Примеры:  
- **AnonymousClassQueen.java:** Анонимный подкласс Group с override bestAlbum(), передача в showGroup().

3) Объяснение темы:  
Anonymous classes — inline подклассы для one-off overrides (e.g., method), без named class. Implements/extends on-the-fly, useful для callbacks или simple adapters (e.g., Comparator). В примере: new Group() { @Override public String bestAlbum() { return "..."; } } для Queen album, вызов showGroup (assumes static void showGroup(Group g) { System.out.println(g.bestAlbum()); }).

4) Основные методы и особенности:  
- **new SuperClass() { @Override method() { ... } }:** Instantiation с body; access outer vars (final).  
- **Group.bestAlbum():** Overridden return "A Night At The Opera"; called in showGroup.  
- **showGroup(Group):** Param accepts anonymous instance; println result.  
- Особенности: No constructor args here; pre-lambda (Java 8+ use ->); compile-time type Group; no reuse (inline); add import для Group if needed; output "A Night At The Opera".

**Проверка работы:** Компилируется с классом Group (abstract/public String bestAlbum();) и showGroup method (e.g., static in same file). Выполняется: вывод "A Night At The Opera". Без Group/showGroup — cannot find symbol. Standalone с добавлением: public abstract class Group { public abstract String bestAlbum(); } static void showGroup(Group g) { System.out.println(g.bestAlbum()); }.

### 5) Тема: Определение пользовательских аннотаций (custom annotations с @Target и @Inherited)

2) Примеры:  
- **CodeAuthorAnnotation.java:** Базовая @interface CodeAuthor с элементами (name required, defaults для version/edited, array assistants).  
- **CodeAuthorInheritedAnnotation.java:** То же, но с @Inherited для наследования подклассами.

3) Объяснение темы:  
@interface определяет аннотации: @Target для scope (TYPE=class/interface), elements как methods (String[] array). @Inherited позволяет propagation to subclasses. Для metadata (e.g., @CodeAuthor(name="Author", assistants={"A","B"})), processed at compile/runtime via reflection. Примеры: reusable для docs или tools, defaults simplify usage.

4) Основные методы и особенности:  
- **@interface CodeAuthor { String name(); int version() default 1; ... }:** Elements=methods; array via String[].  
- **@Target({ElementType.TYPE}):** Restricts to classes; @Inherited для subclass inheritance.  
- **String[] assistants();:** Multi-value; edited default "01/01/1970".  
- Особенности: Retention default RUNTIME (add @Retention); no body in @interface; use via @CodeAuthor(name="X") on class; reflection: getAnnotation(); compile OK standalone, no main (meta).

**Проверка работы:** Оба компилируются standalone (import java.lang.annotation.*;). Нет runtime (declarations); test: add class @CodeAuthor(name="Test") public class Test {}, compiles. @Inherited: subclass inherits (check via getAnnotation()). Utility, no output; integrates with processors.

### 1) Тема: Анонимные внутренние классы (anonymous inner classes для overrides)

2) Примеры:  
- **AnonymousClassPinkFloyd.java:** Анонимный подкласс Group с override bestAlbum(), присвоение к переменной и вызов метода с print.

3) Объяснение темы:  
Анонимные классы — inline подклассы для one-off overrides (e.g., method), без named class. Implements/extends on-the-fly, useful для callbacks или simple adapters (e.g., Comparator). В примере: new Group() { @Override public String bestAlbum() { return "Wish You Were Here"; } } для Pink Floyd, вызов bestAlbum() и print. Это демонстрирует создание экземпляра с кастомной логикой без отдельного класса, аналогично предыдущим примерам с Queen.

4) Основные методы и особенности:  
- **new SuperClass() { @Override method() { ... } }:** Instantiation с body; access outer vars (final).  
- **Group.bestAlbum():** Overridden return "Wish You Were Here"; called on pinkFloyd instance.  
- **String album = pinkFloyd.bestAlbum(); System.out.println(album):** Вызов и вывод.  
- Особенности: No constructor args; pre-lambda (Java 8+ use ->); compile-time type Group; no reuse (inline); requires abstract Group { public abstract String bestAlbum(); }; output "Wish You Were Here".

**Проверка работы:** Компилируется с абстрактным классом Group (public abstract String bestAlbum();). Выполняется без ошибок: вывод "Wish You Were Here". Без Group — cannot find symbol. Standalone с добавлением Group; аналогично AnonymousClassQueen, но с присвоением к переменной для reuse.