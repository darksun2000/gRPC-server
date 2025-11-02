# syntax=docker/dockerfile:1
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY . .
RUN mvn -q -DskipTests package  # produces target/gateway-1.0.0.jar (shaded content)

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /src/target/gateway-1.0.0.jar /app/app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/app/app.jar"]