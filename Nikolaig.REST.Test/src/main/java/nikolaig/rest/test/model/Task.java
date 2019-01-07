package nikolaig.rest.test.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "task")
public class Task {

	@Id
	public ObjectId _id;
	
	private String name;
	
	
	// ObjectId needs to be converted to string
	public String get_id() {
		return _id.toHexString();
	}
	

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
