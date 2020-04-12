# Spring Boot Rest Api that uses JDBC Template with H2 database

> A SpringBoot Project with in-memory H2 database, scheduler and REST template. Creates random student every 5 seconds, insert to H2 database, show student object(s) as JSON via endpoint URL.

## Installation

```sh
git clone https://github.com/zeynepoztug/java_rest/
```

```sh
cd <to_your_project_directory>
```

```sh
mvn spring-boot:run
```

## Docker
Build Docker image
```sh
cd <to_your_project_directory>
```
```sh
sudo docker build -t spring-boot:1.0 .
```

```sh
sudo docker run -d -p 8080:8080 -t spring-boot:1.0
```
Go to
[http://localhost:8080/students](http://localhost:8080/students)

You can get students by id
[http://localhost:8080/students/1](http://localhost:8080/students/1)
