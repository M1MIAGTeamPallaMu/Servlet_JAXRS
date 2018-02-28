package rest;

import domain.Home;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jpa.HomeDao;

@Path("/home")
public class HomeServices {

  private HomeDao dao = new HomeDao();

  /**
   * Return all homes.
   */
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public Response homes() {
    return this.response(this.dao.readAll());
  }


  /**
   * Create a new home .
   */
  @POST
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({MediaType.APPLICATION_JSON})
  public Response add(Home h) {
    this.dao.create(h);
    return this.homes();
  }

  /**
   * Return one home by it's {id} .
   */
  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON})
  public Response find(@PathParam("id") int id) {
    return this.response(this.dao.read(id));
  }

  private Response response(Object o) {
    return Response.ok(o).build();
  }

}
