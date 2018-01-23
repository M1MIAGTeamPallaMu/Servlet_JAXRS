package rest;

import domain.Person;
import jpa.GenTestDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/peoplapi")
public class PeopleServices {
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

    @POST
    @Path("/addPerson")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response personPost(Person p){
        genTestDAO.create(p);
        return Response.status(201).entity(p).build();
    }

    @DELETE
    @Path("deletePerson/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") int id){
        this.genTestDAO.delete(this.genTestDAO.read(id, Person.class));
        return this.people();
    }

    private Response response(Object o){
        return Response.ok(o).build();
    }

}
