FROM  registry.global.ccc.srvb.bo.paas.cloudcenter.corp/sanes-vostok-test-san/graalvm-ce-maven:java11-21.0.0.2-RC2


ARG NATIVE_FILE

ADD $NATIVE_FILE /tmp/native_file

ENTRYPOINT ["/tmp/native_file"]
