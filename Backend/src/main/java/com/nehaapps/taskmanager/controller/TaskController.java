package com.nehaapps.taskmanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.nehaapps.taskmanager.model.Task;
import com.nehaapps.taskmanager.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin("http://localhost:5173")
public class TaskController {
    
    public static List<Task> li = new ArrayList<>();
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Task> getTasks(){ 
    System.out.println("getTasks called");
    System.out.println(li);
    return repository.findAll();
}
   @GetMapping("/{id}")
   public ResponseEntity<Task> getTaskbyID(@PathVariable String id){
    
    return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
       }

   @DeleteMapping("delete/{id}")
   public ResponseEntity<?> deleteTaskById(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted Successfully");
        }
   //return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND); 

  @PutMapping("update/{id}")
  public ResponseEntity<?> updateTasks(@PathVariable String id, @RequestBody Task updatedTask) {
    Optional<Task> optionalTask=repository.findById(id);
    if(optionalTask.isEmpty()){
        return ResponseEntity.notFound().build();
        }
    Task existingTask=optionalTask.get();
    existingTask.setTitle(updatedTask.getTitle());
    existingTask.setCompleted(updatedTask.isCompleted());
    repository.save(existingTask);
    return ResponseEntity.accepted().build();
    
    
}

      // Using @RequestBody with validation
    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody @Validated Task request) {
        System.out.println(request);
        // Simulate processingm
       // Task newtask = new Task( request.getTitle(), request.isCompleted());
       Task savedTask = repository.save(request);
        
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
}
}