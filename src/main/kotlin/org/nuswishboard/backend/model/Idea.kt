package org.nuswishboard.backend.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Idea(
    val idea: String,
    val owner: String,
    val description: String? = null,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    val addedAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
