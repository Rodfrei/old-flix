FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY api/src /app/src
COPY api/pom.xml /app
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:11-jre-slim
COPY --from=build app/target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","/app/api-0.0.1.jar" ]