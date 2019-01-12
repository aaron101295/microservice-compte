FROM openjdk:8
ADD target/microservice-compte.jar microservice-compte.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "microservice-compte.jar"]