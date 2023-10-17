package connection.platforms.ConnectionPlatforms.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import connection.platforms.ConnectionPlatforms.table.PlatformTable;

@Repository
public class PlatformRepo {
	
	private MongoTemplate temp;
	private Class<PlatformTable> table = PlatformTable.class;
	
	private Query quickQuery(String id) {
		return new Query(Criteria.where("_id").is(id));
	}
	
	public List<PlatformTable> getAll(String collection) {
		return temp.findAll(table, collection);
	}
	
	public void insertNewTable(PlatformTable table, String collection) {
		temp.insert(table, collection);
	}
	
	public String updateValue(String value, String collection, String id) {
		Query q = quickQuery(id);
		Update u = new BasicUpdate(value);
		UpdateResult result = temp.updateFirst(q, u, collection);
		
		return "Updated "+result.getModifiedCount();
	}
	
	public String deleteTable(String id, String collection) {
		Query q = quickQuery(id);
		DeleteResult result = temp.remove(q, collection);
		return "Deleted "+result.getDeletedCount();
	}

}
