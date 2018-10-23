package rest.starWars.dataServices;

import java.util.ArrayList;

import rest.starWars.constants.LightsaberColour;
import rest.starWars.models.Jedi;
import rest.starWars.utils.BinarySearch;

public class JediDataService {
	private ArrayList<Jedi> jedis = new ArrayList<Jedi>();	
	
	public ArrayList<Jedi> getJedis() {
		createFakeData();
		return jedis;
	}
	
	public Jedi getJedi(String name) {		
		return null;
	}
	
	public Jedi getJedi(int id) {
		createFakeData();
		int index = BinarySearch.binarySearch(jedis, id);
		if(index == -1) {
			return null;
		}
		
		return jedis.get(index);
	}
	
	private void createFakeData() {
		jedis.add(new Jedi(3, "Joda", LightsaberColour.GREEN));
		jedis.add(new Jedi(1, "Obi Wan Kenobi", LightsaberColour.BLUE));
		jedis.add(new Jedi(2, "Luke Skywalker", LightsaberColour.BLUE));
		jedis.sort((Jedi jedi1, Jedi jedi2) -> jedi1.compareTo(jedi2));
	}
}
