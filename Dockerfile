FROM  registry.global.ccc.srvb.bo.paas.cloudcenter.corp/sanes-vostok-test-san/naive-demo-task:001


ARG NATIVE_FILE

ADD $NATIVE_FILE /tmp/native_file

ENTRYPOINT ["/tmp/native_file"]
