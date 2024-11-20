# Use Maven image with OpenJDK 17 base
FROM maven:3.8.6-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use OpenJDK to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/portfolio-1.0-SNAPSHOT.jar ./portfolio-1.0-SNAPSHOT.jar

# Expose the application port
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "portfolio-1.0-SNAPSHOT.jar"]
