FROM openjdk:11

ADD ./target/FGF-0.0.1-SNAPSHOT.jar /usr/src/FGF-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "FGF-0.0.1-SNAPSHOT.jar"]