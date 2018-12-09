package starWars.models;

import starWars.constants.LightsaberColour;

public class Jedi {
	private Integer id;
	private String name;
	private LightsaberColour lightsaberColour;

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
