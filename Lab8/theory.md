* Стандартные исключения
    * Какие знаете
        * **ArithmeticException** - *арифметическая ошибка.*
        * **NullPointerException** - *пустая ссылка.*
        * **ArrayIndexOutOfBoundsException** - *выход за границу массива.*
        * **IllegalArgumentException** - *неверный аргумент при вызове метода.*
        * **IndexOutOfBoundsException** - *тип индекса вышел за допустимые пределы.*
        * **NegativeArraySizeException** - *создан массив отрицательного размера.*
        * **NumberFormatException** - *неверное преобразование строки в числовой формат.*
        * **StringIndexOutOfBounds** - *попытка использования индекса за пределами строки.*
        * **Exception** - *перехват любых исключений.*
    * С какими вы сталкивались, где лежат
* Обработка исключений
    * **try-catch** - *в блоке **try** помещается код, который может породить исключение. Существует совместно с блоком **catch()**, который служит "ловушкой" для поимки исключения, в качестве аргумента указывается имя исключения и объект исключения.*
    * **try-catch-finally** - *всё тоже самое, что и для **try-catch**, только код, расположенный в блоке **finally** будет выполнен в любом случае, не является обязательным.*
    * **Типизация исключений** - *существует множество различных типов исключений.*
    * **Множество catch** - *у одного блока **try** может быть более одного блока **catch()**.*
* throw vs throws
    * **throw** - *позволяет создать собственные исключения.*
    * **throws** - *если метод может породить исключение, которое он сам не обрабатывает, он должен задать это поведение так, чтобы вызывающий его код мог позаботиться об этом исключении. Для этого к объявлению метода добавляется конструкция throws, которая перечисляет типы исключений (кроме исключений Error и RuntimeException и их подклассов).*
* **Создание собственных исключений** - *нужно наследоваться от Exception, затем объявить собственное исключение и прописать логику возникновения данного исключения.*
    * Хороший тон