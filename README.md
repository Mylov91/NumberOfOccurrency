# Number Of Occurences Application
REST API, вычисляющий частоту встречи символов по заданной строке


## Содержание
  - [Технологии](#технологии)
  - [Функционал](#функционал)
  - [Запуск приложения](#запуск-приложения)
  - [Входящие параметры](#входящие-параметры)
  - [Покрытие тестами](#покрытие-тестами)
  - [Автор проекта](#автор-проекта)


## Технологии
- [Java 17](https://www.java.com/ru/)
- [Spring Boot 3.2.2](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html)


## Функционал
Приложение принимает на вход сообщение и выдает набор символов, входящих в него, и количество раз, которое этот символ встречается в собщении. Набор отсортирован в порядке убывания количества вхождений символа в переданное сообщение.

## Запуск приложения
Для запуска приложения потребуется скачать проект, открыть вкладку терминала в папке проекта, скомпилировать код командой
```
mvn compile
```
а затем, запустить приложение командой
```
mvn exec:java -Dexec.mainClass="ru.mylov.numberofoccurrences.NumberOfOccurrences"
```

## Входящие параметры
Передача входящиих данных осуществляется путем осуществления GET HTTP запроса на URL
```
http://localhost:8080/api/count
```
и передачи текста в качестве параметра запроса "message", например, 
```
localhost:8080/api/count?message=aaaaabcccc
```
В случае корректного переданного входящего запроса, ответом  будет являться набор символов и частота их вхождения в переданное сообщение с HTTP статусом "200 OK" в формате
```
{a=5, c=4, b=1}
```
### Ограничения входящего сообщения:
- **Не должно быть пустым**

  В случае, если сообщение пустое, выбрасывается кастомное исключение EmptyMessageException с HTTP статусом "400 Bad Request" c указанием причины возникновения и времени возникновения
  ```
  {
      "responseMessageText": "Message must not be empty",
      "time": "2024-02-09 15:49:19"
  }
  ```

- **Не должно содержать никаких символов, кроме букв**
  
  В случае, если сообщение содержит символы, отличные от букв, выбрасывается кастомное исключение WrongMessageCharactersException с HTTP статусом "400 Bad Request" c указанием причины возникновения и времени возникновения
  ```
  {
      "responseMessageText": "Message must contain only letters",
      "time": "2024-02-09 15:53:52"
  }
  ```

- **Не должно быть более 20 символов**
  
  В случае, если сообщение содержит более 20 символов, выбрасывается кастомное исключение WrongMessageLengthException с HTTP статусом "400 Bad Request" c указанием причины возникновения и времени возникновения
  ```
    {
      "responseMessageText": "Message must be less than 20 characters",
      "time": "2024-02-09 15:56:07"
  }
  ```
  

## Покрытие тестами
Приложение покрыто модульными тестами, проверяющими корректность работы сервисного класса, а именно:
- Проверка корректности подсчета частоты вхождения символов в переданное сообщение
- Проверка корректности работы кастомных исключений в случае неверного входящего сообщения

## Автор проекта
  - [Мылов Сергей](https://github.com/Mylov91) — Java-developer (Mylov91@yandex.ru)
