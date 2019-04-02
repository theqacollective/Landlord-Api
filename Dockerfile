FROM maven as build
WORKDIR /build
COPY pom.xml .
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/Landlord-Api-0.0.1-SNAPSHOT.jar  landlord.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","landlord.jar"]
