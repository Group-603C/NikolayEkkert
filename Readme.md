<h1>Лабораторные работы по Java</h1>

***

<h4>Содержание:</h4>

*   [Лаб.№1 - FizzBuzz](#lab1)
*   [Лаб.№2 - Массивы](#lab2)
*   [Лаб.№3 - Коллекции](#lab3)
*   [Лаб.№4 - Работа с файлами](#lab4)
*   [Лаб.№5 - Formatter](#lab5)
*   [Лаб.№6 - Класс "Точка"](#lab6)
*   [Лаб.№7 - Математические выражения](#lab7)
*   [Лаб.№8 - Exceptions](#lab8)
*   [Лаб.№9 - Generics](#lab9)


***

<h2 id="lab1">Лабораторная работа №1 - FizzBuzz</h2>

1) __FizzBuzz__. 
Напишите программу, которая выводит на экран числа от 1 до 100. При этом вместо чисел, кратных трем, программа должна выводить слово Fizz, а вместо чисел, кратных пяти — слово Buzz. Если число кратно пятнадцати, то программа должна выводить слово FizzBuzz. Задача может показаться очевидной, но нужно получить наиболее простое и красивое решение.

2) __Простое число__. 
Реализуйте метод для проверки числа на простоту. 

```java
boolean isSimple(int number);
```

3) __Скобки__. 
Реализовать метод, который по заданной скобочной последовательности говорит, “правильная” ли она.

```java
boolean isCorrect(String sequence);
```

>Правильной скобочной последовательностью называется такая последовательность, в которой для каждой открывающейся скобки справа от неё найдётся соответствующая ей закрывающая, и наоборот: для каждой закрывающей скобки слева от неё найдётся соответствующая ей открывающая. Пример: (), (()()), ()()()()(()) - правильные последовательности; ()), )(, (())()()) - неправильные.

<h4>Обратить внимание:</h4>

* С чего начинается программа на Java
* Форматирование кода
	* Сочетание клавиш для быстрого форматирования кода
	* Быстрое изменение имени переменных (Refactor, Rename)
* Более простые решения
* Как оформляются методы

***

<h2 id="lab2">Лабораторная работа №2 - Массивы</h2>

Реализовать набор методов для нахождения статических характеристик массива.

```java
class ArrayAnalizer {
 
    ArrayAnalizer(int[] entities)
 
    int findMinimum();
    int findMaximum();
    double findAverage();
    double findMedian();
    double findGeometricAverage();
}
```

<h4>Обратить внимание:</h4>

* Проверки:
	* Крайние случаи
	* Входные параметры
	* Допустимость операций
* Использование встроенных функций:
	* min
	* max
* Крайние значения:
	* Что должно возвращать для пустого массива
* Side-effect
* Наименование:
	* Избыточные названия тоже плохо
	* Правильное название методов
* Области памяти
* Где хранится:
	* Программа
	* фукнция
	* Локальная переменная
	* Статическая переменная
	* Динамические данные
* Различные типы (разница, передача, side-effect):
	* Ссылочный типы
	* Value-типы
* Стек вызовов:
	* Как работает
	* Для чего нужен
	* Что храниться

***

<h2 id="lab3">Лабораторная работа №3 - Коллекции</h2>

Реализовать класс с методом  для вычисления математического выражения.
Используя встроенную коллекцию Stack, перевести математическое выражение из инфиксной записи в обратную польскую, а затем вычислить его.
В качестве операций использовать:
1) __+__
2) __-__
3) __*__
4) __/__
5) __()__

```java
class Calculator {

    static double calculate(String expresion);
}
```

<h4>Обратить внимание:</h4>

* Имена:
	* Класса
	* Переменных
	* Методов
* Проверка входных данных
* Unit-тесты

***

<h2 id="lab4">Лабораторная работа №4 - Работа с файлами</h2>

Реализовать класс с набором методов анализа файла.

```java
class FileAnalizer {
 
    public FileAnalizer(String path);
 
    public int countLetters();
    public int countWords();
    public int countLines();
    public Map<char,int> countFrequencyCharacteristic();
}
```

>Частотная характеристика это таблица, где для каждого символа указано как часто он встречается. Более подробное объяснение (http://www.abakbot.ru/online-5/97-freq-letter).

<h4>Обратить внимание:</h4>

* Обработка исключений
* Юнит тесты
* Освобождение ресурсов
* Уровни доступа
* ООП

***


<h2 id="lab5">Лабораторная работа №5 - Formatter</h2>

Реализовать метод для форматирвоания строки. На выходе должна получится единая строка со вставленными по правилам аргументами. Аргументы вставляются в строку через {}.

```java
class Formatter {
 
    static String build(String formatString, Object... arguments);
}
```

```java
//Example
String result = Formatter.build("Hello {0}, I am {1} years old", "hell", 15);
System.out.println(result); //Hello hell, I am 15 years old
```
<h4>Обратить внимание:</h4>

* Возможные типы данных
	* Реализацию println
* Перевод объекта в строку
* Важное свойство строк, их изменяемость
* Применение StringBuilder

***


<h2 id="lab6">Лабораторная работа № 6 - Класс "Точка"</h2>

Реализовать класс Точка с необходимыми методами.

```java
public class Point {
 
    Point(double x, double y);
    Point(double x, double y, double z);
 
    double getX();
    double getY();
    double getZ();
 
    double distanceTo(Point point);
 
    PolarPoint toPolar();
    CylindricalPoint toCylindrical();
 
    static isOneStraightLine(Point first, Point send, Point third);
    static isOnePlane(Point first, Point send, Point third, Point fourth);
}

public class PolarPoint() {
 
    PolarPoint(double rho, double phi);
 
    double getRho();
    double getPhi();
 
    Point toCartesian()
}

public class CylindricalPoint() {
 
    CylindricalPoint(double rho, double phi, double z);
 
    double getRho();
    double getPhi();
    double getZ();
 
    Point toCartesian()
}
```

<h4>Обратить внимание:</h4>

* Принципы ООП
	* Наследование
	* Инкапсуляция
	* Полиморфизм
* Валидация входных параметров

***

<h2 id="lab7">Лабораторная работа №7 - Математические выражения</h2>

Реализовать набор классов, для описания и составления мат выражений. Основная задач уметь составлять полноценные выражения, хоть и в префиксной записи

* Описать базовый интерфейс Expression, содержащий метод calculate(). 
* Отнаследовать два вида выражений: UnaryExpression и BinaryExpression.
* Реализовать функциональность в классах
    * Addition
    * Subtraction
    * Multiplication
    * Division
    * Rest
    * Power
    * Negative
    * Absolute
    * Square
    * Value
* О иерархии наследования догадайтесь сами
* Необходимы конструкторы для работы в том числе с int и double

```java
interface Expression {
 
    double calculate();
}
class UnaryExpression: Expression  {
//...
}
class BinaryExpression: Expression  {
//...
}
```

<h4>Обратить внимание:</h4>

* ООП
    * Перегрузки
    * **final**
    * Таблица виртуальных методов 


***

<h2 id="lab8">Лабораторная работа №8 - Exceptions</h2>

Реализовать класс со следующим интерфейсом и поведением.

```java
class Locker {
     
    void set(int value);
    int get()
    void lock();
    void unlock();
}
```

<h4>Обратить внимание:</h4>

* Стандартные исключения
	* Рассказать какие знаете
	* С какими сталкивались на практике и где они лежат
* Обработка исключений
	* try - catch
	* try - catch - finally
	* Типизация исключений
	* Множество catch
* throw vs throws
* Создание собвстенных исключений
	* Хороший тон
	

Помощь: 
https://beginnersbook.com/2013/04/try-catch-in-java/
https://beginnersbook.com/2013/04/java-finally-block/
https://beginnersbook.com/2013/04/user-defined-exception-in-java/
https://beginnersbook.com/2013/04/difference-between-throw-and-throws-in-java/ 

***

<h2 id="lab9">Лабораторная работа №9 - Generics</h2>

Реализовать свой список (LinkedList).

```java
class LinkedList<T> implements Iterable<T> {
     
    LinkedList();
    LinkedList(Iterable<T> entities);
 
    void add(T value);
    void add(Iterable<T> range);
    void addToBegin(T value);
    void insert(T value, int position);
 
    boolean removeFirst();
    boolean removeLast();
    boolean remove(T value);
    boolean remove(int position);
    boolean removeAll();
 
    T find(int index);
    int indexOf(T value);
     
    T first();
    T last();
    boolean isEmpty();
    int length();
}
```

<h4>Обратить внимание:</h4>

* Generic
    * Что это
    * Отличие от шаблонов в С++
    * Существуют ли они на момент исполнения
* Структуры данных (объяснить что это и какие свойства есть)
    * Очередь 
    * Стек
    * Словарь (Map)
    * Список
        * Односвязный
        * Двусвязный
        * Циклический
        * Основное преимущество и недостаток перед массивом

Помощь:
http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Iterable.html