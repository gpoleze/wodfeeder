FROM openjdk:14

LABEL maintainer="gabriel.poleze@gmail.com"

ARG BASE_FILE

ENV BASE_FOLDER=/web-server
ENV JAR_FILE="$BASE_FOLDER/$BASE_FILE"

COPY ./build/libs $BASE_FOLDER

ENTRYPOINT java -jar $JAR_FILE