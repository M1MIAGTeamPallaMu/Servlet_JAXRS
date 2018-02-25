package rest;

import domain.Home;
import jpa.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/home")
public class HomeServices {
    private HomeDAO dao = new HomeDAO();

    /**
     * Return all homes
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response homes(){
        return this.response(this.dao.readAll());
    }


    /**
     * Create a new home
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response add(Home h){
        this.dao.create(h);
        return this.homes();
    }

    /**
     * Return one home by it's {id}
     * @return
     */
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
