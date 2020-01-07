 FROM openjdk:8-jdk
 RUN apt-get --quiet update --yes
 RUN apt-get --quiet install --yes wget tar unzip lib32stdc++6 lib32z1
 RUN wget --quiet --output-document=android-sdk.zip https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip
 RUN unzip -d android-sdk-linux android-sdk.zip
 RUN echo y | android-sdk-linux/tools/bin/sdkmanager "platforms;android-28" >/dev/null
 RUN echo y | android-sdk-linux/tools/bin/sdkmanager "platform-tools" >/dev/null
 RUN echo y | android-sdk-linux/tools/bin/sdkmanager "build-tools;29.0.2" >/dev/null
 ENV ANDROID_HOME=/android-sdk-linux
 ENV PATH=$PATH:/android-sdk-linux/platform-tools/
 SHELL ["/bin/bash", "+o", "pipefail", "-c"]
 RUN yes | android-sdk-linux/tools/bin/sdkmanager --licenses
 SHELL ["/bin/bash", "-o", "pipefail", "-c"]
 RUN apt-get update -qq && apt-get install -y -qq lftp