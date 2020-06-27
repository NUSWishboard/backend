package org.nuswishboard.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditModel(
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    @JsonIgnore
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    @JsonIgnore
    var updatedAt: LocalDateTime? = null
) : Serializable
