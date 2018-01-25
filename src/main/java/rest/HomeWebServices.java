package rest;

import domain.Home;
import jpa.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/home")
public class HomeWebServices {
    private HomeDAO dao = new HomeDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response homes(){
        return this.response(this.dao.readAll());
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response add(Home h){
        this.dao.create(h);
        return Response.status(201).entity(h).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response readHome(@PathParam("id") int id){
        return this.response(this.dao.read(id));
    }


    private Response response(Object o){
        return Response.ok(o).build();
    }

}
