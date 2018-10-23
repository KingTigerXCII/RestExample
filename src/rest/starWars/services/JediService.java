package rest.starWars.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import rest.starWars.dataServices.JediDataService;
import rest.starWars.models.Jedi;

@Path("/jedis")
public class JediService {
	JediDataService jediDataService = new JediDataService();
	
	@GET
	@Path("{id}")
	public String getJediPlainText(@QueryParam("id")int id) {
		Jedi jedi = jediDataService.getJedi(id);
		return "Hello " + jedi.getName() + " " + jedi.getLightsaberColour();
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public ArrayList<Jedi> getJediJson() {
		return jediDataService.getJedis();
	}
}
