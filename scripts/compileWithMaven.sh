#!/usr/bin/env bash

GREEN='\033[0;32m'
RED='\033[0;31m'
BLUE='\033[0;34m'
NC='\033[0m'

printf "=== ${BLUE}Building %s sample${NC} ===\n" "${PWD##*/}"

rm -rf target
mkdir -p target/native-image

echo "Packaging ${PWD##*/} with Maven"
mvn -ntp -Pnative-image package -s /tmp/settings.xml &> target/native-image/output.txt
echo "end Build ******************************"


#if [[ -f target/${PWD##*/} ]]
if [[ -f target/task-demo-native ]]
then
  printf "${GREEN}SUCCESS${NC}\n"
else
  cat target/native-image/output.txt
  printf "${RED}FAILURE${NC}: an error occurred when compiling the native-image.\n"
  exit 1
fi
