FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

# Copy the application jar
COPY --from=build /target/com-0.0.1-SNAPSHOT.jar com.jar

# Copy the CA certificate into the Docker image
COPY ca-cert.pem /usr/local/share/ca-certificates/ca-cert.crt
RUN update-ca-certificates

EXPOSE 8080
ENTRYPOINT ["java","-jar","com.jar"]