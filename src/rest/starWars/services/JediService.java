package rest.starWars.services;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.starWars.dataServices.JediDataService;
import rest.starWars.models.Jedi;

@Path("/jedis")
@RequestScoped
public class JediService implements Serializable {
	
	@EJB
	JediDataService jediDataService;
	private static final long serialVersionUID = 7864602476359850890L;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJedi(@PathParam("id")Integer id) {
		Jedi jedi = jediDataService.getById(id);
		if(jedi == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK).entity(jedi)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJedi() {
		ArrayList<Jedi> jedis = jediDataService.getAll();
		return Response.status(Response.Status.OK).entity(jedis)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createJedi(Jedi jedi) {		
		try {
			jediDataService.create(jedi);
		} catch(Exception exception) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();			
		}
	
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteJedi(@PathParam("id")Integer id) {
		try {
			jediDataService.removeById(id);
		} catch(Exception exception) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
