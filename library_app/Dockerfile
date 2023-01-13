FROM openjdk:17

COPY .mvn/ .mwn
COPY target/*.jar library_app.jar

CMD ["java", "-jar" , "/library_app.jar"]