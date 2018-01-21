package rest;

import domain.Home;
import jpa.HomeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/home")
public class HomeWebServices {
    private HomeDAO dao = new HomeDAO();

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response homes(){
        return this.response(this.dao.readAll());
    }

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response homePost(Home h){
        dao.create(h);
        String result = "" + h.toString();
        return Response.status(201).entity(result).build();
    }

    @GET
    @Path("/home/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Home home(@PathParam("id") int id){
        return (Home) this.dao.read(id);
    }


    private Response response(Object o){
        return Response.ok(o).build();
    }

}
