FROM maven:latest as maven-build
WORKDIR /build
COPY . /build
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
EXPOSE 8083
COPY --from=maven-build /build/target/LandlordAPI-0.0.1-SNAPSHOT.jar landlordapi.jar
ENTRYPOINT ["java", "-jar", "landlordapi.jar"]