@echo off
setlocal

echo Stoping containers
docker compose -f deployment\docker-compose\infra.yml -f deployment\docker-compose\apps.yml stop

echo Clearing containers...
docker compose -f deployment\docker-compose\infra.yml -f deployment\docker-compose\apps.yml rm -f

endlocal