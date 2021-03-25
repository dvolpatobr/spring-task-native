#!/usr/bin/env bash

sdk use java 21.0.0.2.r8-grl
gu install native-image
native-image --version

scripts/compileWithMaven.sh && scripts/test.sh