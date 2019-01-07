package nikolaig.rest.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import nikolaig.rest.test.repositories.TaskRepository;
import nikolaig.rest.test.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserTaskController {

	  @Autowired
	  private UserRepository userRep;
	  
	  @Autowired
	  private TaskRepository taskRep;
	  
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<User> getAllUsers() {
		  
	    return userRep.findAll();
	  }
	  
	  
	  @RequestMapping(value = "/task/", method = RequestMethod.GET)
	  public List<Task> getAllTasks() {
		  
	    return taskRep.findAll();
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public User getUserById(@PathVariable("id") ObjectId id) {
		  
	    return userRep.findBy_id(id);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteUser(@PathVariable ObjectId id) {
	    userRep.delete(userRep.findBy_id(id));
	  }
	  
	  @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
	  public void deleteTask(@PathVariable ObjectId id) {
	    taskRep.delete(taskRep.findBy_id(id));
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public User createUser(@Valid @RequestBody User user) {
	    user.set_id(ObjectId.get());
  
	    userRep.save(user);
	    return userRep.findBy_id(user._id);
	  }
	  
	  @RequestMapping(value = "/task/", method = RequestMethod.POST)
	  public Task createTask(@Valid @RequestBody Task task) {
		  task.set_id(ObjectId.get());
  
		  taskRep.save(task);
	    return taskRep.findBy_id(task._id);
	  }
	  
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
	    user.set_id(id);
	    userRep.save(user);
	  }
	  
	  
	  @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
	  public void modifyTaskById(@PathVariable("id") ObjectId id, @Valid @RequestBody Task task) {
	    task.set_id(id);
	    taskRep.save(task);
	  }
}
