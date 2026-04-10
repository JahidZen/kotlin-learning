package com.jahid.bootcamp_api.repository

import com.jahid.bootcamp_api.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository<Task, Long> {
    // Empty! Spring generates all the CRUD code for you automatically.
}