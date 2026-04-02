# Use Java 17 (Eclipse Temurin)
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Spring Boot jar into container
COPY ./target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]