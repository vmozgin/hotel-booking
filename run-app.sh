#!/usr/bin/env bash
mvn clean package
docker-compose down -v --remove-orphans
docker rmi hotel-booking
docker compose up -d