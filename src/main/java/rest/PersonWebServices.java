package rest;


import domain.Person;
import jpa.PersonDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonWebServices {

    private PersonDAO dao = new PersonDAO();

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response people(){
        return this.response(this.dao.readAll());
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response personPost(Person p){
        dao.create(p);
        String result = "" + p.toString();
        return Response.status(201).entity(result).build();
    }

    @GET
    @Path("/person/{id}/devices")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personDevices(@PathParam("id") int id){
        return this.response(this.person(id).getDevices());
    }

    @GET
    @Path("/person/{id}/homes")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personHomes(@PathParam("id") int id){
        return this.response(this.person(id).getHomes());
    }

    @GET
    @Path("/person/{id}/friends")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personFriends(@PathParam("id") int id){
        return this.response(this.person(id).getFriends());
    }

    @GET
    @Path("/person/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Person person(@PathParam("id") int id){
        return (Person) this.dao.read(id);
    }

    private Response response(Object o){
        return Response.ok(o).build();
    }
}
