package starWars.dao;

import java.util.List;

import starWars.models.Jedi;

public interface JediDao {
	void create(Jedi jedi);
	void removeAll();
	void removeByName(String name);
	void removeById(int id);
	List<Jedi> getAll();
	Jedi getByName(String name);
	Jedi getById(int id);
}
