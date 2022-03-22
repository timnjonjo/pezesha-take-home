
FROM openjdk:8-jre-alpine
LABEL maintainer="timnjonjo@gmail.com"
RUN apk add --no-cache bash
ENV TZ=Africa/Nairobi
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
EXPOSE 8080
ADD target/*.jar  sampleconsumer.jar
CMD /bin/sh -c 'touch /sampleconsumer.jar'
ENTRYPOINT ["java","-Xmx256m","-Djava.security.egd=file:/dev/./urandom","-jar","/sampleconsumer.jar"]