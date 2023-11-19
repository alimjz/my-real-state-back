FROM amazoncorretto:17.0.0-alpine
RUN apk add --no-cache tzdata
ENV TZ=Asia/Tehran

WORKDIR /app
COPY target/*.jar my-real-state-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "my-real-state-0.0.1-SNAPSHOT.jar"]
