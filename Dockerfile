FROM gradle:6.8.3-jdk8
COPY . /usr/src/automation
WORKDIR /usr/src/automation
RUN gradle clean build -x test
RUN chmod -R 777 /usr/src/automation
CMD [ "./run.sh" ]