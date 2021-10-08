FROM openjdk:17-jdk

# Install Apache Maven
RUN microdnf install maven

COPY . /usr/src/java-17-for-absolute-beginners
WORKDIR /usr/src/java-17-for-absolute-beginners

EXPOSE 9000

RUN mvn clean install site site:stage site:run -Pdocs

