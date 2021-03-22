# Reqres Automation

This project is an automation implementation for https://reqres.in/

## Features

- User oriented evidences
- Easy to run
- Jenkinsfile to run on your jenkins server with podtemplate
- using screenplay patten

This text you see here is *actually- written in Markdown! To get a feel
for Markdown's syntax, type some text into the left window and
watch the results in the right.

## Tech Stack
- [Java] - HTML enhanced for web apps!
- [Gradle] - awesome web-based text editor
- [SerenityBDD framework] - Markdown parser done right. Fast and easy to extend.


## Run

To run this project you have three options:

1. If you have gradle cli you only need to execute on your cmd this:
    gradle clean test -PENVURL="https://reqres.in"

```sh
gradle clean test -PENVURL="https://reqres.in"
```

2. If you dont have gradle cli please go to https://gradle.org/install/ or you can use the gradle wrapper executing this:

```sh
gradlew.bat clean test -PENVURL="https://reqres.in"
```
or
```sh
./gradlew clean test -PENVURL="https://reqres.in"
```
3. If you have docker you can run with:
```sh
docker build -t reqres:1.0 .
docker run --name reqresrun reqres:1.0
docker cp reqresrun:/usr/src/automation/target/site/serenity .
```
and go to the folder serenity and open index.html

## Parallel execution

- is is being controlled by gradle on build.gradle file with:

 maxParallelForks = Runtime.runtime.availableProcessors()

- the parallel jenkins option would make a two reports and two junit results. that is a problem.

## Notification
- If you have slack you can change the slack webhook on run.sh file, for this example the format is  this one:
![alt text](https://github.com/boya678/reqres_automation/blob/master/evidences/SlackNotify.jpg)

- There is a lot of ways to nofity for example jenkins has plugin for discord, slack, etc. but in this case i used curl with and slack webhook.


#Evidences:
- Exercise evidences on report.zip in evidences folder
- the jenkins evidences are on evidences folder on project path
- the SerenityBDD evidences are on the project path under target/site/serenity/index.htmlor if you executed with docker are on current path serenity/index.html