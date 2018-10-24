package rest.starWars.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.starWars.dataServices.JediDataService;
import rest.starWars.models.Jedi;

@Path("/jedis")
public class JediService {
	JediDataService jediDataService = new JediDataService();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJediPlainText(@PathParam("id")Integer id) {
		Jedi jedi = jediDataService.getJedi(id);
		if(jedi == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK).entity(jedi)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJediJson() {
		ArrayList<Jedi> jedis = jediDataService.getJedis();
		return Response.status(Response.Status.OK).entity(jedis)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createJedi(Jedi jedi) {
		Jedi jediWithDbId;
		
		try {
			jediWithDbId = jediDataService.createJedi(jedi);
		} catch(Exception exception) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();			
		}
	
		return Response.status(Response.Status.OK).entity(jediWithDbId)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteJedi(@PathParam("id")Integer id) {
		try {
			jediDataService.deleteJedi(id);
		} catch(Exception exception) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
