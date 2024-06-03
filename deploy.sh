#!/bin/bash

sudo yum install java-21-amazon-corretto

./gradlew build

java -jar build/libs/demo-0.0.1-SNAPSHOT.jar