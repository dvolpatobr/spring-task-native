#!/usr/bin/env bash

native-image --version

scripts/compileWithMaven.sh
#&& scripts/test.sh