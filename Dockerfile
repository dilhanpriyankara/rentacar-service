# ============================
# 1️⃣ Build Stage
# ============================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# ============================
# 2️⃣ Runtime Stage
# ============================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copy only the jar from the build stage
COPY --from=build /app/target/*.jar app.jar
# Expose the Spring Boot port
EXPOSE 8080
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]