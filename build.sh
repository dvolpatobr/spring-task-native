#!/usr/bin/env bash

native-image --version

scripts/compileWithMaven.sh -Dspring.native.build-time-properties-checks=default-include-all -Dspring.native.build-time-properties-match-if-missing=false -Dspring.native.factories.no-actuator-metrics=true
#&& sleep 3 && ${PWD%/*samples/*}/scripts/test.sh
#&& scripts/test.sh