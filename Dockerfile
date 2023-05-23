FROM openjdk:11
LABEL maintainer="Abel"
ADD target/packagetrackingservice-0.0.1-SNAPSHOT.jar packagetrackingimage.jar
ENTRYPOINT ["java","-jar","packagetrackingimage.jar"]