FROM openjdk:11-jre

ADD src/main/resources/jmx/jmx-exporter-config.yaml .
ADD lib/jmx_prometheus_javaagent-0.20.0.jar .
ADD target/poc-external-task.jar app.jar

EXPOSE 8080 12345

ENTRYPOINT ["java","-javaagent:jmx_prometheus_javaagent-0.20.0.jar=12345:jmx-exporter-config.yaml","-jar","app.jar"]
