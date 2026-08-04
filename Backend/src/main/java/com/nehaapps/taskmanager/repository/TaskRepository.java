package com.nehaapps.taskmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nehaapps.taskmanager.model.Task;

public interface TaskRepository extends MongoRepository<Task,String> {

}
