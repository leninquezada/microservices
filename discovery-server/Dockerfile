FROM openjdk:11
VOLUME /tmp
ADD discovery-server-0.0.1-SNAPSHOT.jar discovery-server.jar
EXPOSE 8671
ENTRYPOINT ["java","-jar", "/discovery-server.jar"]