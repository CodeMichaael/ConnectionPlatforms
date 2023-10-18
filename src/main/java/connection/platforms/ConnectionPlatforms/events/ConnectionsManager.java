package connection.platforms.ConnectionPlatforms.events;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import connection.platforms.ConnectionPlatforms.repository.PlatformRepo;
import connection.platforms.ConnectionPlatforms.table.PlatformTable;

@RestController
@RequestMapping("/connections")
public class ConnectionsManager {
	
	@Autowired
	private PlatformRepo repo;
	private PlatformTable table;
	
	@PostMapping("/connect-to/{connectionId}")
	public String connectToId(@RequestParam("connectionId") String connectionId, @RequestBody String id, String user, String compId) {
		boolean result = repo.valueExists("connectionId_manager", connectionId);
		
		if (result) {
			repo.updateValue(id, "loggedIntoComputer", compId);
			repo.updateValue(id, "connectionId", null);
			return "Connected to "+user;
		}
		return "Connection ID not found.";
	}
	
	@GetMapping("/connect-getall/")
	public List<PlatformTable> getAll(@RequestBody String collection) {
		return repo.getAll(collection);
	}
	
	
	// Code below

}

