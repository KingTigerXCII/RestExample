package starWars.rest.resources;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import starWars.daoImpl.JediDaoImpl;
import starWars.models.Jedi;

@RequestScoped
@Path("/jedis")
public class JediResource implements Serializable {
	
	@Inject
	JediDaoImpl jediDaoImpl;
	private static final long serialVersionUID = 7864602476359850890L;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJedi(@PathParam("id")Integer id) {
		Jedi jedi = jediDaoImpl.getById(id);
		if(jedi == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK).entity(jedi)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJedis() {
		List<Jedi> jedis = jediDaoImpl.getAll();
		return Response.status(Response.Status.OK).entity(jedis)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createJedi(Jedi jedi) {		
		try {
			jediDaoImpl.create(jedi);
		} catch(Exception exception) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();			
		}
	
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteJedi(@PathParam("id")Integer id) {
		try {
			jediDaoImpl.removeById(id);
		} catch(Exception exception) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK)
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	public Response deleteAllJedi() {
		try {
			jediDaoImpl.removeAll();
		} catch(Exception exception) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.status(Response.Status.OK)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
