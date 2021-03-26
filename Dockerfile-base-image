FROM  ghcr.io/graalvm/graalvm-ce:java8-21.0.0.2

RUN curl -O https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN tar xzf apache-maven-3.6.3-bin.tar.gz -C /usr/local
RUN cd /usr/local && ln -s apache-maven-3.6.3 maven

RUN cd ~
ENV M2_HOME="/usr/local/maven"
ENV PATH="${M2_HOME}/bin:${PATH}"

RUN gu install native-image && native-image --version

RUN mvn --version


ADD ./ /tmp/task-demo-nat/


RUN cd /tmp/task-demo-nat/  && chmod 777 -R * && ls -la

ENTRYPOINT bash



