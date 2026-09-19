# ================= 階段一：編譯打包 (名稱叫 builder) =================
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /build

COPY gradlew .
COPY gradle gradle
COPY *.gradle* .

RUN --mount=type=cache,target=/root/.gradle \
    chmod +x ./gradlew && ./gradlew build -x test --no-daemon || true

COPY . .

RUN --mount=type=cache,target=/root/.gradle \
    ./gradlew bootJar -x test --no-daemon

FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=builder /build/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
