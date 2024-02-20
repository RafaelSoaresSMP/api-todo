package com.apitodo.todo.services;

import com.apitodo.todo.dtos.TaskRecordDTO;
import com.apitodo.todo.models.TaskModel;
import com.apitodo.todo.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//essa anotaoca fala para o spring que ie um servidoer e deixa isso passivel de injecao
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> list(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return taskRepository.findAll(sort);
    }

    public List<TaskModel> create(TaskModel Task){
        taskRepository.save(Task);
        return list();
    }

    public List<TaskModel> update(UUID id, TaskRecordDTO task){
        Optional<TaskModel> taskO = taskRepository.findById(id);
        if(taskO.isEmpty()){
            return null;
        } else {
            TaskModel existingTask = taskO.get();
            BeanUtils.copyProperties(task, existingTask);
            taskRepository.save(existingTask);
            return list();
        }
    }

    public List<TaskModel> delete(UUID id){
        taskRepository.deleteById(id);
        return list();
    }


}
