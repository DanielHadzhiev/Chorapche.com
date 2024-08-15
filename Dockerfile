FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Chorapche.com-0.0.1-SNAPSHOT.jar Chorapche.com.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Chorapche.com.jar"]