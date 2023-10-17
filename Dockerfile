ARG JAVA_IMAGE=markhobson/maven-chrome:jdk-11

FROM $JAVA_IMAGE AS base
RUN mkdir -p /home/automation/app && chown root:root /home/automation
WORKDIR /home/automation
USER root
RUN mkdir tmp

FROM base AS build
COPY --chown=root:root . .

FROM base AS production
ENV BASE_URL_TRAINING=https://learn.outsystems.com/training
ENV USER_PORTAL_TRAINING=${USER_PORTAL_TRAINING}
ENV PASSWORD_PORTAL_TRAINING=${PASSWORD_PORTAL_TRAINING}

COPY --chown=root:root --from=build /home/automation .

CMD ["tail", "-f", "/dev/null"]