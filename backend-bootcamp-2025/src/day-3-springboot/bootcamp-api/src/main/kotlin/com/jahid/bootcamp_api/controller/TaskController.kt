package com.jahid.bootcamp_api.controller

import com.jahid.bootcamp_api.model.Task
import com.jahid.bootcamp_api.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {


    @GetMapping
    fun getAllTasks(): List<Task> {
        return taskService.getAllTasks()
    }


    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): ResponseEntity<Task> {
        val task = taskService.getTaskById(id)
        return if (task.isPresent) {
            ResponseEntity.ok(task.get())
        }
        else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createTask(@RequestBody task: Task): ResponseEntity<Task> {
        val createdTask = taskService.createTask(task)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask)
    }


    @PostMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody task: Task): ResponseEntity<Task> {
        val saved = taskService.updateTask(id, task)
        return if (saved == null) {
            ResponseEntity.notFound().build()
        }
        else {
            ResponseEntity.ok(saved)
        }
    }




    @PutMapping("/{id}")
    fun letsUpdateTask(@PathVariable id: Long, @RequestBody task: Task): ResponseEntity<Task> {
        val updated = taskService.updateTask(id, task)
        return if (!taskService.existsById(id)) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(updated)
        }
    }




    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long): ResponseEntity<Void> {
        if (!taskService.existsById(id)) {
            return ResponseEntity.notFound().build()
        }

        else {
            taskService.deleteTask(id)
        }
        return ResponseEntity.noContent().build()
    }
}