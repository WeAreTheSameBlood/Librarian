FROM openjdk:17

COPY /target/Librarian-0.0.1-SNAPSHOT.jar ./libr.jar

CMD ["java", "-jar", "/libr.jar"]