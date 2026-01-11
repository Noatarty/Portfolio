#!/bin/bash

docker run --tty --interactive --rm --volume "$PWD":/projet --shm-size=2G --add-host host.docker.internal:host-gateway --publish 9000:9000 robot-selenium "$@"
