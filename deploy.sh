#!/bin/bash

sudo yum install java-21-amazon-corretto

git clone https://github.com/tomershefi/parkingLot.git

cd parkingLot

./gradlew build

java -jar build/libs/demo-0.0.1-SNAPSHOT.jar