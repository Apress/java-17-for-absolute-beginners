FROM openjdk:17-jdk

# Install Zulu OpenJDK 17 , Oracle JDK requires manual confirmation
# RUN wget https://cdn.azul.com/zulu/bin/zulu17.28.13-ca-jdk17.0.0-linux_amd64.deb -O  /tmp/zulu17.28.13-ca-jdk17.0.0-linux_amd64.deb
#RUN apt install --assume-yes /tmp/zulu17.28.13-ca-jdk17.0.0-linux_amd64.deb

# Install Apache Maven
RUN microdnf install maven

COPY . /usr/src/java-17-for-absolute-beginners
WORKDIR /usr/src/java-17-for-absolute-beginners
RUN mvn