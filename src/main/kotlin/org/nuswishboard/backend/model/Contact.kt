package org.nuswishboard.backend.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sun.istack.NotNull
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "contacts")
class Contact(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @NotNull
    var contact: String,
    var description: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idea_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    var idea: Idea? = null
) : AuditModel() {
    fun setContact(newContact: String): Contact {
        this.contact = newContact
        return this
    }

    fun setDescription(newDescription: String): Contact {
        this.description = newDescription
        return this
    }
}
