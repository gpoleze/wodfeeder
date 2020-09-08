#!/bin/bash

sha="$(git rev-parse --short HEAD)"
timestamp="$(date --utc +%FT%TZ)"

appVersion="$timestamp-$sha"
echo "$appVersion"

curl -n -X PATCH "https://api.heroku.com/apps/wf-web-client/config-vars" \
  -H "Authorization: Bearer ${secrets.HEROKU_API_TOKEN}" \
  -H "Accept: application/vnd.heroku+json; version=3" \
  -H "Content-Type: application/json" \
  -d "{\"REACT_APP_WEB_CLIENT_VERSION\": \"$appVersion\"}"