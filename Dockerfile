# pre-fetch dependencies
FROM maven:3.8.5-openjdk-17 AS DEPENDENCIES

WORKDIR /app

COPY rest-service/pom.xml rest-service/pom.xml
COPY rest-client/pom.xml rest-client/pom.xml
COPY common/pom.xml common/pom.xml
COPY pom.xml .

RUN mvn -B -e org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline \
    -DexcludeArtifactIds=common

# build the jar
FROM maven:3.8.5-openjdk-17 AS BUILDER

WORKDIR /app

COPY --from=DEPENDENCIES /root/.m2 /root/.m2
COPY --from=DEPENDENCIES /app/ /app
COPY rest-service/src /app/rest-service/src
COPY rest-client/src /app/rest-client/src
COPY common/src /app/common/src

RUN mvn -B -e clean package -DskipTests

# prepeare runtime env
FROM openjdk:17-slim

WORKDIR /app

COPY --from=BUILDER /app/rest-service/target/*.jar /app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]