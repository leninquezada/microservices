FROM openjdk:11
VOLUME /tmp
ADD api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar", "/api-gateway.jar"]