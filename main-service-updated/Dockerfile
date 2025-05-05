FROM maven:3.8.5-openjdk-17 AS build
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build target/main-service-0.0.1-SNAPSHOT.jar /app/main-service.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","main-service.jar"]
