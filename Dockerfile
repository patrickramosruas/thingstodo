FROM openjdk:11.0.11-jdk-buster

RUN mkdir /usr/thingstodo

COPY target/thingstodo-0.0.1-SNAPSHOT.jar /usr/thingstodo/app.jar

WORKDIR /usr/thingstodo

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java --enable-preview $JAVA_OPTS -jar app.jar" ]
