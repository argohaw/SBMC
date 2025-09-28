@echo off
setlocal

echo Building Catalog-Service image...
call mvnw.cmd -pl catalog-service spring-boot:build-image -DskipTests || exit /b 1

echo Starting containers...
docker compose -f deployment\docker-compose\infra.yml -f deployment\docker-compose\apps.yml up -d

endlocal
