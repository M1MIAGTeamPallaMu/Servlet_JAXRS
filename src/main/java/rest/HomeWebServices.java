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
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response add(Home h){
        this.dao.create(h);
        return this.homes();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") int id){
        return this.response(this.dao.read(id));
    }

    private Response response(Object o){
        return Response.ok(o).build();
    }

}
