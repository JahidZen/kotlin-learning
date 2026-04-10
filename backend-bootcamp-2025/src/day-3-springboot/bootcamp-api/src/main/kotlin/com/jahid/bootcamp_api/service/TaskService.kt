package com.jahid.bootcamp_api.service

import com.jahid.bootcamp_api.model.Task
import com.jahid.bootcamp_api.repository.TaskRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service


@Service // We put service annotation here because Spring needs to know that it has to create task object
         // from this class. It's the service logic and Spring needs to create objects from it
         // and return to TaskController and TaskController will return it to the web client in JSON format
         // If we don't use @Service here, Spring will not know from where to create that object,
         // It comes here to the TaskService to look for the class, it finds nothing, so it shows error
         // Basically, wherever we use the main operation or business logic of an application, we use the @Service annotation.
class TaskService(private val taskRepository: TaskRepository) {
    fun getAllTasks(): List<Task> {
        return taskRepository.findAll()
    }


    fun createTask(task: Task): Task {
        return taskRepository.save(task)
    }


    fun getTaskById(id: Long) = taskRepository.findById(id)


    fun updateTask(id: Long, updatedTask: Task): Task? {
        if (!taskRepository.existsById(id)) return null

        val taskToSave = updatedTask.copy(id = id)
        return taskRepository.save(taskToSave)
    }


    fun existsById(id: Long) = taskRepository.existsById(id)
    fun deleteTask(id: Long) = taskRepository.deleteById(id)
}