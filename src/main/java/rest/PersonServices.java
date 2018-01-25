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
    public Response personHomes(@PathParam("id") int id){
        return this.response(this.person(id).getHomes());
    }

    @GET
    @Path("/{id}/friends")
    @Produces({MediaType.APPLICATION_JSON})
    public Response personFriends(@PathParam("id") int id){
        return this.response(this.person(id).getFriends());
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Person person(@PathParam("id") int id){
        return (Person) this.dao.read(id);
    }

    @POST
    @Path("/add")
    public Response personPost(@FormParam("name") String name, @FormParam("surname") String surname, @FormParam("email") String email){
        Person p = new Person(name, surname, email);
        dao.create(p);
        System.out.println(p.toString());
        return Response.status(201).entity("added" + name + " " + surname + " " + email).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id){
        Person p = (Person) this.dao.read(id);
        this.dao.delete(p);
        return Response.status(204).entity("deleted" + p.toString()).build();
    }

    private Response response(Object o){
        return Response.ok(o).build();
    }

}
