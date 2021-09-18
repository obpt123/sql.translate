#!/usr/bin/env bash

build_and_push()
{
  docker-compose build && docker-compose push
}

DOCKER_USERNAME=$1
DOCKER_PASSWORD=$2
echo "${DOCKER_PASSWORD}" | docker login -u ${DOCKER_USERNAME} --password-stdin
build_and_push
docker logout