FROM eclipse-temurin:21-jdk
RUN apt-get update && apt-get install -y curl
COPY /target/BellTestBench-0.0.1-SNAPSHOT.jar BellTestBench.jar
EXPOSE 8081
CMD ["java", "-jar", "BellTestBench.jar"]