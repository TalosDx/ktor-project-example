FROM gradle:7.5.0-jdk17-alpine as build
WORKDIR workspace/app

COPY src src
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradle.properties .
RUN gradle buildFatJar --no-daemon

FROM openjdk:17-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/*-all.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080/tcp
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]