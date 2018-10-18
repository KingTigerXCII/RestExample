package rest.starWars.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import rest.starWars.dataServices.JediDataService;
import rest.starWars.models.Jedi;

@Path(JediService.webContextPath)
public class JediService {
	static final String webContextPath = "/jedis";
	JediDataService jediDataService = new JediDataService();
	
	@GET
	@Path("{id}")
	public String getJediPlainText(@QueryParam("name")String name) {
		Jedi jedi = jediDataService.getJedi(name);
		return "Hello " + jedi.getName() + " " + jedi.getLightsaberColour();
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public ArrayList<Jedi> getJediJson() {
		return jediDataService.getJedis();
	}
}
