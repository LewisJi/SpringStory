FROM eclipse-temurin:17-jdk AS builder

WORKDIR /build

COPY . .

RUN chmod +x ./gradlew && ./gradlew bootJar -x test --no-daemon

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=builder /build/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]