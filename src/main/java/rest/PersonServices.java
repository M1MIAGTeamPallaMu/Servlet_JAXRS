package rest;

import domain.Person;
import jpa.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonServices {
    private PersonDAO dao = new PersonDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response people(){
        return this.response(this.dao.readAll());
    }

    @GET
    @Path("/{id}/devices")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personDevices(@PathParam("id") int id){
       return this.response(this.person(id).getDevices());
    }

    @GET
    @Path("/{id}/homes")
    @Produces({MediaType.APPLICATION_JSON})
    public Response homes(@PathParam("id") int id){
        return this.response(this.person(id).getHomes());
    }

    @GET
    @Path("/{id}/friends")
    @Produces({MediaType.APPLICATION_JSON})
    public Response friends(@PathParam("id") int id){
        return this.response(this.person(id).getFriends());
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Person person(@PathParam("id") int id){
        return this.dao.read(id);
    }

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response add(Person p){
        this.dao.create(p);
        return this.people();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") int id){
        Person p = this.dao.read(id);
        this.dao.delete(p);
        return this.people();
    }

    private Response response(Object o){
        return Response.ok(o).build();
    }

}
