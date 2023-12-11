FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY .mvn/ ./.mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw install

HEALTHCHECK --interval=5s --timeout=60s --start-period=5s --retries=25 \
    CMD curl --fail http://localhost:8080/api/v1/health || exit 1

CMD ["java", "-jar", "./target/icsnetwork-0.0.1-SNAPSHOT.jar", \
    "--spring.datasource.url=jdbc:postgresql://postgres:5432/postgres", \
    "--spring.datasource.username=postgres", \
    "--spring.datasource.password=password", \
    "--spring.datasource.driver-class-name=org.postgresql.Driver"]
