package rest.starWars.dataServices;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import rest.starWars.dbRepositories.JediRepository;
import rest.starWars.models.Jedi;

@Stateless
public class JediDataService implements JediRepository {
	
	private static final String collectionName = "Jedi";
	
	@PostConstruct
	public void init() {
	}

	@Override
	public void create(Jedi jedi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Jedi getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jedi getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Jedi> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
