package rest.starWars.models;

import rest.starWars.constants.LightsaberColour;

public class Jedi implements Comparable<Jedi> {
	private Integer id;
	private String name;
	private LightsaberColour lightsaberColour;
	
	public Jedi(Integer id, String name, LightsaberColour lightsaberColour) {
		this.setId(id);
		this.setName(name);
		this.setLightsaberColour(lightsaberColour);
	}
	
	@Override
	public int compareTo(Jedi jedi) {
		return this.getId() - jedi.getId();
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LightsaberColour getLightsaberColour() {
		return lightsaberColour;
	}

	public void setLightsaberColour(LightsaberColour lightsaberColour) {
		this.lightsaberColour = lightsaberColour;
	}
}
