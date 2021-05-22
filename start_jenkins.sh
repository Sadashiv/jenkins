#!/bin/bash

SCRIPTPATH="$( cd -- "$(dirname "$0")" >/dev/null 2>&1 ; pwd -P )"
JENKINS_LTS_VERSION=2.277.4
JENKINS_PORT=8888

#kill -SIGTERM `ps -aef | grep 'jenkins' | grep -v grep | awk '{print $2}'`

#echo "Terminated the JENKINS SERVER"

export JENKINS_HOME=$SCRIPTPATH
if [ ! -d $SCRIPTPATH/downloads ];
then
    mkdir -p $SCRIPTPATH/downloads
fi

if [ ! -d $SCRIPTPATH/downloads/$JENKINS_LTS_VERSION ];
then
     mkdir -p $SCRIPTPATH/downloads/$JENKINS_LTS_VERSION
     wget -c https://get.jenkins.io/war-stable/$JENKINS_LTS_VERSION/jenkins.war -P $SCRIPTPATH/downloads/$JENKINS_LTS_VERSION
fi

#/usr/bin/java -Dhudson.util.ProcessTree.disable=true -Dmail.smtp.localhost=smtp.gmail.comm -jar $SCRIPTPATH/downloads/$JENKINS_LTS_VERSION/jenkins.war --httpPort=8888 --logfile=$cwd/jenkins.log --daemon
/usr/bin/java -jar $SCRIPTPATH/downloads/$JENKINS_LTS_VERSION/jenkins.war --httpPort=$JENKINS_PORT --logfile=$SCRIPTPATH/jenkins.log --daemon > /dev/null
echo "/usr/bin/java -jar $SCRIPTPATH/downloads/$JENKINS_LTS_VERSION/jenkins.war --httpPort=$JENKINS_PORT --logfile=$SCRIPTPATH/jenkins.log --daemon > /dev/null"
if [ $? -ne 0 ];
then
   echo "************************************************************"
   echo "ERROR: Jenkins LTS version $JENKINS_LTS_VERSION failed to start"
   echo "Please look into issue ==> $SCRIPTPATH/jenkins.log"
   echo "************************************************************"
   exit 1
else
   echo "****************************************************"
   echo "Jenkins LTS version $JENKINS_LTS_VERSION started with port $JENKINS_PORT "
   echo "Access Jenkins master URL ===> http://127.0.0.1:$JENKINS_PORT"
   echo "****************************************************"
fi


