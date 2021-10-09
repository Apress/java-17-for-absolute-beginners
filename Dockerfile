FROM openjdk:17-jdk

# Install Apache Maven
RUN microdnf install maven

WORKDIR /usr/src/java-17-for-absolute-beginners

EXPOSE 9000

CMD mvn clean install site site:stage site:run -Pdocs

