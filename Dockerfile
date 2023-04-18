FROM openjdk:11
VOLUME /tmp
ADD build/libs/ejercicio-0.0.1-SNAPSHOT.jar ejercicio.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ejercicio.jar"]