FROM amazoncorretto:17-alpine

# Copy jar file
COPY target/*.jar /app.jar

# run the app
CMD ["/usr/bin/java", "-jar", "/app.jar"]

# expose the port
EXPOSE 8085
