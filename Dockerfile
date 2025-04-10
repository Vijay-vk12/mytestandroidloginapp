# Use an official OpenJDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy JAR file from target directory to the container
COPY target/*.jar app.jar

# Expose port (Render will set PORT as env var)
EXPOSE 8080

# Run the JAR file with dynamic port if needed
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
