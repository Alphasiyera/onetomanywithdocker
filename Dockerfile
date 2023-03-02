FROM openjdk:11
COPY target/onetomany-0.0.1-SNAPSHOT.jar .
EXPOSE 8114
CMD ["java", "-jar", "/onetomany-0.0.1-SNAPSHOT.jar"]