package rest.starWars.dataServices;

import java.util.ArrayList;

import rest.starWars.constants.LightsaberColour;
import rest.starWars.models.Jedi;

public class JediDataService {
	public ArrayList<Jedi> getJedis() {
		Jedi jedi1 = new Jedi("Obi Wan Kenobi", LightsaberColour.Blue);
		Jedi jedi2 = new Jedi("Darth Vader", LightsaberColour.Red);
		
		ArrayList<Jedi> jedis = new ArrayList<Jedi>();		
		jedis.add(jedi1);
		jedis.add(jedi2);
		
		return jedis;
	}
	
	public Jedi getJedi(String name) {
		Jedi jedi = new Jedi("Obi Wan Kenobi", LightsaberColour.Blue);
		return jedi;
	}
}
