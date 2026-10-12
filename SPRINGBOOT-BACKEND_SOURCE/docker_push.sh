#!/usr/bin/env bash
set -e

./mvnw clean install -DskipTests=true
docker build -t simplybyte/simplybyte-backend:1.0 .

echo "$DOCKER_TOKEN" | docker login -u "$DOCKER_USER" --password-stdin

docker push simplybyte/simplybyte-backend:1.0
