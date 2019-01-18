#!/bin/env bash
# Underconstraction
# create a shared folder to store reports in
mkdir shared
# include shared folder when running docker
# make sure you move your reports into the shared folder while in docker
docker run -v "$PWD/shared:/shared" ...
#   |----- inside docker container
#   | # run test
#   | mv coverage.txt shared
# now run codecov in project directory to discover reports in shared folder
bash <(curl -s https://codecov.io/bash)

