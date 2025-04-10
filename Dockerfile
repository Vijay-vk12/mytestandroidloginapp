# ---------- Build Stage ----------
FROM maven:3.9.5-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom and source files
COPY pom.xml .
COPY src ./src

# Build jar file
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port (Render uses dynamic PORT env variable)
EXPOSE 8080

# Run the application with dynamic port
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
