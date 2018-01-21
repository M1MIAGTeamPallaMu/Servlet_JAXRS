package rest;

import domain.Home;
import domain.Person;
import jpa.GenTestDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WebServices {
    private GenTestDAO genTestDAO = new GenTestDAO();

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String sayHello() {
        return "Hello, Welcome to the Opower API";
    }

    @GET
    @Path("/people")
    @Produces({MediaType.APPLICATION_JSON})
    public Response people(){
        return this.response(this.genTestDAO.getEntityManager().
                createQuery("from Person", Person.class).
                getResultList());
    }

    @GET
    @Path("/people/{id}/devices")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personDevices(@PathParam("id") int id){
       return this.response(this.person(id).getDevices());
    }

    @GET
    @Path("/people/{id}/homes")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personHomes(@PathParam("id") int id){
        return this.response(this.person(id).getHomes());
    }

    @GET
    @Path("/people/{id}/friends")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personFriends(@PathParam("id") int id){
        return this.response(this.person(id).getFriends());
    }

    @GET
    @Path("/people/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Person person(@PathParam("id") int id){
        return (Person) this.genTestDAO.read(id, Person.class);
    }

    private Response response(Object o){
        return Response.ok(o).build();
    }

}
