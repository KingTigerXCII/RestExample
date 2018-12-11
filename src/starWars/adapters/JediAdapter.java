package starWars.adapters;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

import starWars.models.Jedi;

public class JediAdapter {
	
	private static Gson gson = new Gson();

	public static final BasicDBObject toDbObject(Jedi jedi) {
		String jediJson = gson.toJson(jedi);
		return (BasicDBObject) JSON.parse(jediJson);
	}
	
	public static final Jedi toJediObject(BasicDBObject dbJedi) {
		return gson.fromJson(dbJedi.toString(), Jedi.class);
	}
}
