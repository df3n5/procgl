#!/bin/bash
mvn package
rm -rvf /opt/tomcat/webapps/*.war
cp -v target/*.war /opt/tomcat/webapps

. ~/.bashrc
cd /opt/tomcat/bin
sudo -E ./catalina.sh stop
sudo -E ./catalina.sh start
