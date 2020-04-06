FROM openjdk:8
ADD target/java_rest-0.0.1-SNAPSHOT.jar java_rest-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","java_rest-0.0.1-SNAPSHOT.jar"]