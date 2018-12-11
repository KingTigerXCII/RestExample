package starWars.models;

import javax.persistence.Id;

import starWars.constants.LightsaberColour;

public class Jedi {
	
	@Id
	private String id;
	private String name;
	private LightsaberColour lightsaberColour;
	
	public Jedi() {	
	}

	public String getId() {
		return id;
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
