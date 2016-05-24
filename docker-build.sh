#!/usr/bin/env bash
./gradlew clean
./gradlew fatJar
docker build -t dbnode .