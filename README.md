# Servlet_JAXRS

In order to run the project you need to launch 'run-hsqldb-server' .bat on windows / .sh on linux to launch the database.
You also have to start tomcat7:run command in order to start the servlet.

The project is provided on localhost:8080 port.

You can import the project in Eclipse or IntelliJ as a Maven project.

# Api routes

Base URI : "localhost:8080/rest/"

| Method     | URL | Action   |
| :------- | ----: | :---: |
| GET    | /person  |  display all the people   |
| GET    | /person/{id}  |  display one specific person with the given {id} parameter   |
| GET    | /person/{id}/devices  |  display all the devices owned by the person with the given {id} parameter   |
| GET    | /person/{id}/homes  |  display all the houses owned by the person with the given {id} parameter   |
| GET    | /person/{id}/friends  |  display all the people friends with a person identified by the given {id} parameter   |
| POST    | /person  |  create a new person   |
| DELETE    | /person/{id}  |  delete one specific person with the given {id} parameter   |
| GET    | /home  |  display all the homes   |
| GET    | /home/{id}  |  display one specific home with the given {id} parameter   |
| POST    | /home  |  create a new home  |
