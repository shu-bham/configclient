FROM adoptopenjdk/openjdk11-openj9:latest
COPY build/libs/configclient-*.jar configclient.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/configclient.jar"]
