# Step 1: Use a base image that contains JDK 17
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the built JAR file from your local machine into the container
COPY target/taskmanger.jar /app/taskmanger.jar

# Step 4: Expose the port on which your app runs (8080 for Spring Boot)
EXPOSE 8080

# Step 5: Command to run the application
ENTRYPOINT ["java", "-jar", "/app/taskmanger.jar"]
