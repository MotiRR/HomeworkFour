# Задание
1. Скачать и установить базу данных на выбор: postgresql ,  mysql, oracle.
2. Создать несколько таблиц (любых), так, что бы между ними было хотя бы отношение «один ко многим» или «многие ко многим»
3. Написать программу, которая будет подключаться к базе данных и производить чтение-запись(в методе main,например, сделать сохранение, обновление, чтение и удаление). 
4. В рамках одной транзакции произвести комплексное обновление связанных таблиц (обновление двух таблиц)
5. Для каждой таблицы должна существовать Entity в вашей программе.
6. Подключение к бд осуществить через Hibernate
7. Конфигурацию подключения вынести в конфигурационный файл, в java коде не хранить конфигурацию.
8. Использовать свойство  ddl.auto update для автоматического обновления схемы бд.

# Инструменты
+ InteliJ IDEA
+ JDK 1.8
+ Maven
+ PostgreSQL 11.5

# Установка
Открываем командную строку в папке с файлов pom.xml и в командной строке пишем
```
mvn clean install
```

# Настройка файла persistance.xml

```
<?xml version="1.0" encoding="UTF-8" ?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">
    <persistence-unit name="ru.sber.edu.entity">
        <properties>
            <property name="hibernate.connection.driver_class" value="org.postgresql.Driver"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQL94Dialect"/>
            <property name="hibernate.connection.url" value="jdbc:postgresql://localhost:5432/{name_database}"/>
            <property name="hibernate.connection.username" value="{name_user}"/>
            <property name="hibernate.connection.password" value="{password_user}"/>
        </properties>
    </persistence-unit>
</persistence>
```
##### Параметры:
{name_database} - название базы данных к которой идет подключение;

{name_user} - имя пользователя работающий с {name_database};

{password_user} - пароль пользователя работающий с {name_database}.

# Запуск
```
mvn exec:java -Dexec.mainClass="ru.sber.edu.Main"
```
