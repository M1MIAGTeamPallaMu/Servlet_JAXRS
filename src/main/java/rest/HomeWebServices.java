package rest;

import domain.Home;
import jpa.GenTestDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/homapi")
public class HomeWebServices {
    private GenTestDAO hdao = new GenTestDAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response homes(){
        return this.response(this.hdao.getEntityManager().
                createQuery("from Home", Home.class).
                getResultList());
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response add(Home h){
        this.hdao.create(h);
        return Response.status(201).entity(h).build();
    }

    @GET
    @Path("/home/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response readHome(@PathParam("id") int id){
        return this.response(this.hdao.read(id, Home.class));
    }


    private Response response(Object o){
        return Response.ok(o).build();
    }

}
