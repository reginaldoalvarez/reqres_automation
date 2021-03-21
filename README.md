Welcome to Reqres Automation

This project was made with SerenityBDD, Screenplay and RestAssured over Java runtime

Requirements:
- java 1.8 (desirable)
- JAVA_HOME environment variable configured

To run this project you have to options:
    1. If you have gradle cli you only need to execute on your cmd this:
        gradle clean test -PENVURL="https://reqres.in"
    2. If you dont have gradle cli please go to https://gradle.org/install/ or you can use the gradle wrapper executing this:
        windows: gradlew.bat clean test -PENVURL="https://reqres.in"
        linux ./gradlew clean test -PENVURL="https://reqres.in"

After run ends the evidences are going to be on the project path under target/site/serenity/index.html

Enjoy it!!

https://giphy.com/gifs/enjoy-eddie-murphy-3o6vXNLzXdW4sbFRGo