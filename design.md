# REST API design model
The REST API will allow creation, retrieval, update and deletion of resources and information 
about persons and their homes.

# ARCHITECTURE AND TECHNOLOGIES 

![Architecture](/architecture.jpg)

As you can see the project is based on a multi-layered application : 

 * The first layer is the Rest support implemented with Jersey, has the role of a facade (facade pattern - ACO module) and delegates the logic to the business or service layer
 
 * The Service layer is where the logic happens
 
 * The Data Access layer is where the communications with the persistence storage takes place.
 
 Now a few list of technologies used during this project : 
  
  1.JERSEY
  
    The Jersey RESTful Web Services framework is open source, production quality, 
    framework for developing RESTful Web Services in Java that provides support for JAX-RS APIs and serves as a JAX-RS Reference Implementation.
  
  2. SERVICE Layer (Domain)
  
    The package domain contains the POJOS.
    
  3.JPA And Hibernate (Persistence layer)
  
    We are using GenTestDao that implements a GenericDao to persist object using JPA and Hibernate.
    On the other hand, we have created a PersonDao class and HomeDao class and they both implement the GenericDao Interface.
    
  4.Tomcat (WEB CONTAINER)
  
    Everything gets packaged with Maven as a .war file and can be deployed on any web container – We are using Tomcat.
   
  

 
# API ROUTES

Resource used : application/json
Base URI : "localhost:8080/rest/"


| Method     | URL | Action   |
| :------- | ----: | :---: |
| GET    | /person  |  displays all the people   |
| GET    | /person/{id}  |  displays one specific person with the given {id} parameter and any other information related to this person   |
| GET    | /person/{id}/devices  |  display all the devices owned by the person with the given {id} parameter   |
| GET    | /person/{id}/homes  |  display all the houses owned by the person with the given {id} parameter   |
| GET    | /person/{id}/friends  |  display all the people friends with a person identified by the given {id} parameter   |
| POST    | /person  |  create a new person   |
| DELETE    | /person/{id}  |  delete one specific person with the given {id} parameter  |
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
