FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean install

FROM openjdk:21-jdk-slim
WORKDIR /app

RUN apt-get update && apt-get install -y tzdata

ENV TZ=America/Sao_Paulo

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=build /app/target/newsletter-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
