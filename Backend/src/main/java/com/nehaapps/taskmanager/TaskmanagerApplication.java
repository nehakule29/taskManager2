package com.nehaapps.taskmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
	
	 public void addTask() {
    li.add(new Task(1, "write code", true));
    li.add(new Task(2,"Learn Springboot",false));
    li.add(new Task(3,"take walk",false)); 
    }
    public static List<Task> li = new ArrayList<>();
    public TaskmanagerApplication() {
        addTask();
    }
   
    
    @GetMapping("/all")
    public List<Task> getTasks(){ 
    System.out.println("getTasks called");
    System.out.println(li);
    return li; 
}
   @GetMapping("/{id}")
   public Task getTaskbyID(@PathVariable Integer id){
    for (Task task : li) {
        if(task.getId()==id){
            System.out.println(task);
            return task;
        }
        else{
            return null;
        }
    }{

    }
    return null;
   }

   @DeleteMapping("delete/{id}")
   public ResponseEntity<?> deleteTaskById(@PathVariable int id){
   for(int i=0 ;i< li.size() ; i++) {
        if(li.get(i).getId()==id){
           li.remove(i);
           String message = "Task" + id + "removed";
           return new ResponseEntity<>(message,HttpStatus.OK);
    }
   }
   return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
} 

  @PutMapping("update/{id}")
  public ResponseEntity<?> updateTasks(@PathVariable int id, @RequestBody Task updatedTask) {
      for(int k=0 ; k<li.size(); k++){
        if(li.get(k).getId()==id){
            li.get(k).setTitle(updatedTask.getTitle());
            li.get(k).setCompleted(updatedTask.isCompleted());
            return new ResponseEntity<>("Updated",HttpStatus.OK);

        }
      }
      return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
  }

	  // Using @RequestBody with validation
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task request) {
        System.out.println(request);
        // Simulate processingm
        int id = TaskmanagerApplication.li.size()+1;
        Task newtask = new Task(id, request.getTitle(), request.isCompleted());
        TaskmanagerApplication.li.add(newtask);
        
        return new ResponseEntity<>(newtask,HttpStatus.CREATED);
    }

}
