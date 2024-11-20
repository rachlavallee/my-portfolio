# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the local project to the container
COPY . /app

# Install Maven (if you need it)
RUN apt-get update && apt-get install -y maven

# Build your project (use your Maven wrapper or Maven command)
RUN ./mvnw clean package

# Command to run your application (adjust as needed)
CMD ["java", "-jar", "target/your-application.jar"]
