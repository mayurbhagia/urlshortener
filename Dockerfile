FROM openjdk:11
COPY /target/urlshortener.jar /usr/src/app/urlshortener.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/src/app/urlshortener.jar"]