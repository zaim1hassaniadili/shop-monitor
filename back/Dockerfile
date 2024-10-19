FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY .env .env
RUN mvn clean package -DskipTests

FROM openjdk:24
WORKDIR /app
COPY --from=build /app/target/back-0.0.1-SNAPSHOT.jar /app/back.jar
COPY .env /app/.env
COPY start.sh /app/start.sh
EXPOSE 8080
ENTRYPOINT ["/app/start.sh"]
