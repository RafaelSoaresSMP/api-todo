package com.apitodo.todo.controllers;

import com.apitodo.todo.dtos.TaskRecordDTO;
import com.apitodo.todo.models.TaskModel;
import com.apitodo.todo.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    @ResponseBody
    List<TaskModel> list(){
        return taskService.list();
    }

    @PostMapping
    @ResponseBody
    List<TaskModel> create(@RequestBody @Valid TaskModel task){
        return taskService.create(task);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    List<TaskModel> delete (@PathVariable(value = "id") UUID id){
        return taskService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    Object update(@PathVariable(value = "id") UUID id, @RequestBody @Valid TaskRecordDTO task){
        return taskService.update(id, task);
    }

}
