FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests=true

FROM openjdk:21-jdk-slim
WORKDIR /app

RUN apt-get update && apt-get install -y tzdata && \
    ln -sf /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime && \
    echo "America/Sao_Paulo" > /etc/timezone && \
    apt-get clean

COPY --from=build /app/target/newsletter-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
