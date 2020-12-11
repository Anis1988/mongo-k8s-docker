FROM openjdk:11-jre-slim

ENV   MONGO_INITDB_ROOT_USERNAME: 'admin' \
      MONGO_INITDB_ROOT_PASSWORD: 'password'

EXPOSE 8080
ADD target/*.jar mongodb-docker.jar
ENTRYPOINT ["java","-jar","/mongodb-docker.jar"]
