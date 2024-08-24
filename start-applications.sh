#!/bin/bash

docker-compose up -d

echo "Starting Springboot Application"
cd hi-there
./mvnw spring-boot:run &
sleep 3
cd -
cd hello-world
./mvnw spring-boot:run &
sleep 3
cd -


