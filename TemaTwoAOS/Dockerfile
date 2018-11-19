FROM openjdk:8

COPY target/TemaTwoAOS-0.0.1-SNAPSHOT

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egdxfile:/dev/./urandom", "-jar", "/app.jar"]