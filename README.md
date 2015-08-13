Nanoservice WAR Demo
================

[German / Deutsch](LIESMICH.md)

This project creates a VM with the complete nanoservices system in
a Docker container. The services are implemented in Java using Spring Boot.

It uses three nanoservices:
- Order to process orders.
- Customer to handle customer data.
- Catalog to handle the items in the catalog.

Each nanoservice is a WAR file. They share a Tomcat to server to run
on.


How To Run
----------

- Install Maven, see https://maven.apache.org/download.cgi
- Install Docker, see https://docs.docker.com/installation/
- Install Virtual Box from https://www.virtualbox.org/wiki/Downloads
- Install Docker Machine, see https://docs.docker.com/machine/#installation
- Go to directory `war-demo` and run `mvn package` there
- Execute `docker-machine create  --virtualbox-memory "4096" --driver
  virtualbox dev` . This will create a new environment called `dev`with Docker
  Machine. It will be virtual machine in Virtual Box with 4GB RAM.
  - Execute `eval "$(docker-machine env dev)"` (Linux / Mac OS X) or
    `docker-machine.exe env --shell powershell dev` (Windows,
    Powershell) /  `docker-machine.exe env --shell cmd dev` (Windows,
    cmd.exe). Now the docker tool will use the newly created virtual
    machine as environment.
- Change to the directory `war-demo` and run `docker build
--tag=war-demo .`followed by `docker run -p 8080:8080 war-demo`.


The result should be:

- Docker Machine creates a new Virtual Box VM with Docker installed.
- Docker images are created and run on that VM.
- Use `docker-machine ip dev` to find the IP adress of the virtual machine.
- You can access the application at http://ipadresss:8080/order/ ,
  http://ipadresss:8080/catalog/ and http://ipadresss:8080/customer/
  . It has a web page with links to all other services.

- Use `docker-machine rm dev` to destroy the virtual machine.
