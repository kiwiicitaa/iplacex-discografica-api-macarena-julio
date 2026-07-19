FROM gradle:8.14-jdk21
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon

FROM eclipse-temurin:21-jdk-jammy
EXPOSE 8080
# Cambia '1' por el nombre de tu archivo jar si es diferente
COPY --from=build /home/gradle/src/build/libs/*-1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
