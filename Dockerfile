FROM java:8

COPY ./build/libs/DBNode-all-1.0-SNAPSHOT.jar .
#RUN javac DBClient.java
CMD ["java", "-jar","DBNode-all-1.0-SNAPSHOT.jar", "9999"]