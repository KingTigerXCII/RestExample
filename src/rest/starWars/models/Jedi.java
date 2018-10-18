package rest.starWars.models;

import rest.starWars.constants.LightsaberColour;

public class Jedi {
	private String name;
	private LightsaberColour lightsaberColour;
	
	public Jedi(String name, LightsaberColour lightsaberColour) {
		this.setName(name);
		this.setLightsaberColour(lightsaberColour);
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
