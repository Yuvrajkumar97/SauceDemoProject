FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /usr/src/app

COPY pom.xml .
COPY testng.xml .
COPY src/ ./src/

RUN mvn clean install

CMD ["mvn", "test"]
