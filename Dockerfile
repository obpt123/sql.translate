FROM openjdk:11.0.12-jre
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/sql.translate-1.0.jar  sql.translate-1.0.jar
ENTRYPOINT ["java", "-jar", "sql.translate-1.0.jar"]
CMD ["-h"]