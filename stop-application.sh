#!/bin/bash

kill `cat ./hello-world/application.pid`
kill `cat ./hi-there/application.pid`

docker-compose down


