FROM docker.io/library/eclipse-temurin:21-jre

WORKDIR /app

COPY target/patient-management-service-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]