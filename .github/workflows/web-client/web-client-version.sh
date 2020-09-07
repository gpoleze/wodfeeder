#!/bin/bash

sha="$(git rev-parse --short HEAD)"
timestamp="$(date --utc +%FT%TZ)"
dotEnv="$(pwd | awk -F '.github' '{print $1}')web-client/.env"

appVersion="$timestamp-$sha"

sed -i -e "s/%WEB_CLIENT_VERSION%/$appVersion/g" "$dotEnv"

cat "$dotEnv"
