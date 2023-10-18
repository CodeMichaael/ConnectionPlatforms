package connection.platforms.ConnectionPlatforms.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;

import connection.platforms.ConnectionPlatforms.table.PlatformTable;

@Repository
public class PlatformRepo {
	
	@Autowired
	private MongoTemplate temp;
	private Class<PlatformTable> table = PlatformTable.class;
	
	private Query quickQuery(String id) {
		return new Query(Criteria.where("_id").is(id));
	}
	
	public List<PlatformTable> getAll(String collection) {
		return temp.findAll(table, collection);
	}
	
	public void updateValue(String id, String value, String newValue) {
		Query q = quickQuery(id);
		Update update = new Update();
		update.set(value, newValue);
		temp.updateFirst(q, update, table);
	}
	
	public void insertNewTable(PlatformTable table, String collection) {
		temp.insert(table, collection);
	}
	
	public boolean valueExists(String field, String value) {
		Query query = new Query(Criteria.where(field).is(value));
		long count = temp.count(query, table);
		
		if (count > 0) return true;
		else return false;
	}
	
	public String deleteTable(String id, String collection) {
		Query q = quickQuery(id);
		DeleteResult result = temp.remove(q, collection);
		return "Deleted "+result.getDeletedCount();
	}

}
