package org.nuswishboard.backend.model

import com.sun.istack.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Email

@Entity
@Table(name = "ideas")
data class Idea(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotNull
    @Column(unique = true)
    val idea: String,
    @Email
    val owner: String,
    val description: String? = null
) : AuditModel()
