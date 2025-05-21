# Use a base image with JDK
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy pom and source
COPY . .

# Build the app
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]