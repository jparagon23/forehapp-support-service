# Etapa 1: Build con GraalVM y Maven
FROM ghcr.io/graalvm/graalvm-ce:21.3.3 AS build

# Instala herramientas necesarias
RUN gu install native-image

WORKDIR /app

# Copia el proyecto
COPY . .

# Usa el wrapper de Maven para compilar en modo nativo
RUN ./mvnw -Pnative -DskipTests clean package

# Etapa 2: Imagen final minimalista
FROM alpine:3.18

# Variables de entorno default (puedes sobreescribirlas en Railway)
ENV MAIL_HOST=dummy.host.com
ENV MAIL_PORT=587
ENV MAIL_USERNAME=dummy@example.com
ENV MAIL_PASSWORD=dummy-pass
ENV SUPPORT_EMAIL_TO=dummy-to@example.com

WORKDIR /app

# Copia el ejecutable nativo desde la etapa anterior
COPY --from=build /app/target/support-service /app/support-service

EXPOSE 8080

# Ejecuta el binario
CMD ["./support-service"]
]