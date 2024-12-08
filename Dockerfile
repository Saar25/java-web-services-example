#
# Build stage
#
FROM eclipse-temurin:17-jdk-alpine AS build

ARG APP_NAME

WORKDIR /app

COPY ./${APP_NAME} ./app

RUN mvnw -f $HOME/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:17-jre-jammy

# copy JRE from the base image
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar", "/app/app.jar"]