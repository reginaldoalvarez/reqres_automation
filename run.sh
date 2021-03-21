#!/bin/bash

gradle clean build test -PENVURL='https://reqres.in'
if [ $? -eq 0 ]; then
    curl -X POST -H 'Content-type: application/json' --data '{"blocks":[{"type":"section","text":{"type":"mrkdwn","text":"*Successful* Reqres api Automated Regression Test :+1:"}}]}' https://hooks.slack.com/services/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
else
    curl -X POST -H 'Content-type: application/json' --data '{"blocks":[{"type":"section","text":{"type":"mrkdwn","text":"*´Failed´* Reqres api Automated Regression Test :-1:"}}]}' https://hooks.slack.com/services/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
fi
