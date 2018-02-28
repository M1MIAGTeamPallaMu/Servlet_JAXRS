# Servlet_JAXRS

# Introduction

This is a practical lab project. The idea is to create some sort of API prototype.
Further details are provided, about how the API works, and the routes that were created to allow its use.

# Installation 

You can clone the project in any directory on your pc, mac or linux system. The project was made using Intellij IDEA 2017.3 version.
After downloading the project, you can import it in Eclipse or IntelliJ as a Maven project.
You will also have to add a **data** folder at the root of the repository.

In order to run the project you need to launch 'run-hsqldb-server' .bat on windows / .sh on linux to launch the database.
Intellij IDEA allows you to install plugins that are responsible for launching bash and cmd scripts.

We are using hibernate in **"dev"** mode, we did not wanted to make it possible for anyone to access remotely the sql database.
To visualize the database state you can install DATAGRIP or install a plugin in Intellij that handles sql database on local machines.

You also have to start tomcat7:run command in order to start the servlet.

We have provided a contact form to add a person's information. 
Its url is under **`localhost:port_number/contact_form/index.html`**.The port number can be configured in the pom.xml file.

You can run a really quick test by using JpaTest class and you will have some records in your database.

Access to the api is under localhost:8080/rest/ . The routes are indicated in the design.md file
From thereon, you will be able to add records using the API. 
Install Postman software or extension on google chrome to easily interact with the API.
