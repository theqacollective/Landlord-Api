FROM maven as build
WORKDIR /build
COPY pom.xml .
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/LandlordAPI-0.0.1-SNAPSHOT.jar  landlord.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","landlord.jar"]
