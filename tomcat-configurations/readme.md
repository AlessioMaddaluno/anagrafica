# Tomcat

In order to setup the web server you could use the *embedded* version of **Tomcat** that comes with Spring Boot, but in order to take the most of this project my tutor decided to use an external version of it, with the purpose of mess with the configuration files and externalize the database configuration.

## Install Tomcat
The projects runs on a Tomcat 9 version. You can get it at the [official website](https://tomcat.apache.org/download-90.cgi). 

 - Download the zip archivie and extract it into a convient location;
 - Done!
 
 ## Override the configurations
It is necessary to override some configuration file in order to add the database as **JNDI Resource** and so on. To do it I inserted the files in this directory. In particular you have to:
 - Put the file *context.xml* into the directory *conf* of the root directory of tomcat downloaded in the last section.

## How to deploy on Tomcat

To deploy on tomcat you have to compile the entire backend. You can do it with the help of an IDE opening the project as a *multimodule project* or go to through the command line with:

    mvn clean install

This will generate a war archivie inside *api/target* directory that you can copy and put into the *webapp* directory inside the tomcat root.

A better approach in my opinion is use the help of the IDE. In my case (An Intellij User) you can automate this operation with the [Smart Tomcat Plugin](https://plugins.jetbrains.com/plugin/9492-smart-tomcat)

## Run the server

If you didnt use the plugin (wich runs the server for you), you can start it using the command line inside the *bin* root of tomcat: 

    catalina.bat run