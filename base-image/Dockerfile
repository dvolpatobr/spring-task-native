FROM  centos:latest



#unzip
RUN yum install zip -y
RUN yum install unzip -y

#GRAAL VM
RUN curl -s "https://get.sdkman.io" | bash
RUN cat "$HOME/.sdkman/bin/sdkman-init.sh"

#ENV M2_HOME="/usr/local/maven"
#ENV PATH="${M2_HOME}/bin:${PATH}"


RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && sdk version && sdk list java
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && sdk install  java 21.0.0.2.r11-grl
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && sdk use java 21.0.0.2.r11-grl  && sdk home java 21.0.0.2.r11-grl && gu install native-image && native-image --version && echo $JAVA_HOME

ENV JAVA_HOME="/root/.sdkman/candidates/java/21.0.0.2.r11-grl"
ENV PATH="${JAVA_HOME}/bin:${PATH}"

RUN native-image --version






#MAVEN
RUN curl -O https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN tar xzf apache-maven-3.6.3-bin.tar.gz -C /usr/local
RUN cd /usr/local && ln -s apache-maven-3.6.3 maven

RUN cd ~
ENV M2_HOME="/usr/local/maven"
ENV PATH="${M2_HOME}/bin:${PATH}"

RUN mvn --version


ENTRYPOINT bash



