FROM openjdk:11-jre-stretch

COPY target/*.jar /app/jebesme.jar

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "app/jebesme.jar"]