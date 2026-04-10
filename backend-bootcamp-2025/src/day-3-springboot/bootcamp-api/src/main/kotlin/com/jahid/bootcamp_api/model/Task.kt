package com.jahid.bootcamp_api.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity // Tells Spring that this is the database model of the table
@Table(name = "tasks") // Optional, gives the database table a name explicitly
data class Task (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val title: String = "",
    val isCompleted: Boolean = false
)