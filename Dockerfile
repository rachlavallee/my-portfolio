# Use an official Maven image to build the app
FROM maven:3.8.6-jdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Build the application (this will create the JAR file)
RUN mvn clean package -DskipTests

# Use an official OpenJDK runtime as the base image to run the app
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/portfolio-1.0-SNAPSHOT.jar ./portfolio-1.0-SNAPSHOT.jar

# Expose the application port (adjust if needed)
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "portfolio-1.0-SNAPSHOT.jar"]
