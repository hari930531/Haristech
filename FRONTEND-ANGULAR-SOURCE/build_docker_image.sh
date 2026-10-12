#!/usr/bin/env bash
set -e

# Build the frontend image
docker build -t simplybyte-frontend .

# Log in to Docker Hub.
# Do NOT hardcode credentials in this file.
# Set them in your shell before running, e.g.:
#   export DOCKER_USER=your-username
#   export DOCKER_TOKEN=your-access-token
echo "$DOCKER_TOKEN" | docker login -u "$DOCKER_USER" --password-stdin

# Tag and push
docker tag simplybyte-frontend "$DOCKER_USER"/simplybyte-ui:2.0
docker push "$DOCKER_USER"/simplybyte-ui:2.0
