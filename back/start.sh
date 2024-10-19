#!/bin/sh

# Check if required environment variables are set and provide defaults or exit with an error
if [ -z "$POSTGRES_URL" ]; then
  echo "POSTGRES_URL is not set"
  exit 1
fi

if [ -z "$POSTGRES_USER" ]; then
  echo "POSTGRES_USER is not set"
  exit 1
fi

if [ -z "$POSTGRES_PASSWORD" ]; then
  echo "POSTGRES_PASSWORD is not set"
  exit 1
fi

# Use the environment variables in the Java command
java -Dspring.datasource.url=${POSTGRES_URL} \
     -Dspring.datasource.username=${POSTGRES_USER} \
     -Dspring.datasource.password=${POSTGRES_PASSWORD} \
     -jar /app/back.jar