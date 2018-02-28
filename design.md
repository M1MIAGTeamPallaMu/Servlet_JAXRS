# REST API design model
The REST API will allow creation, retrieval, update and deletion of resources and information 
about persons and their homes.

# ARCHITECTURE AND TECHNOLOGIES 

![Architecture](/architecture.jpg)

# Api routes

Resource used : application/json
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


## Parameter for POST requests :

 ### /person : 
 
 - name : String
 - surname : String
 - mail  : String


 ### /home : 
 
 - size : Integer
 - rooms : Integer
