# Stage 1: Build the application
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Create the final, small image
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/heartapp-1.0.jar .
CMD ["java", "-jar", "heartapp-1.0.jar"]