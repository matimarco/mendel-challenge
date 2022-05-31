FROM openjdk:16-jdk-alpine
VOLUME /tmp
COPY target/*.jar mendel.jar
ENTRYPOINT ["java","-jar","/mendel.jar"]