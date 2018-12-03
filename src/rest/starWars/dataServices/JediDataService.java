package rest.starWars.dataServices;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;

import rest.starWars.dbRepositories.JediDbRepository;
import rest.starWars.models.Jedi;

@Stateless
@Local
public class JediDataService implements JediDbRepository {
	
	private static final String collectionName = "Jedi";

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
