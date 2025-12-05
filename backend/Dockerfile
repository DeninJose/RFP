# Multi-stage Dockerfile for a Spring Boot application
# Build stage
FROM maven:3-openjdk-17 AS build
WORKDIR /workspace

# Copy Maven wrapper and project definition first for better caching
COPY pom.xml mvnw ./
COPY .mvn .mvn
# Copy source
COPY src ./src

# Build the application (skip tests in image build to speed up)
RUN mvn -B package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Create a non-root user for running the app
RUN useradd -m appuser || true

EXPOSE 8080

# Copy the jar from the build stage
COPY --from=build /workspace/target/backend-0.0.1-SNAPSHOT.jar /app/app.jar

# Run as non-root
USER appuser

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
