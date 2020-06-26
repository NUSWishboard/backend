package org.nuswishboard.backend.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Idea(
    var idea: String,
    var owner: String,
    var description: String? = null,

    @Id @GeneratedValue var id: Long,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
