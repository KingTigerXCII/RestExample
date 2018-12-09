package starWars.dao;

import java.util.ArrayList;

import starWars.models.Jedi;

public interface JediDao {
	void create(Jedi jedi);
	void removeAll();
	void removeByName(String name);
	void removeById(int id);
	void updateByName(String name);
	void updateById(int id);
	ArrayList<String> getAll();
	Jedi getByName(String name);
	Jedi getById(int id);
}
