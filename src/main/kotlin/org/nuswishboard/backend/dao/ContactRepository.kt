package org.nuswishboard.backend.dao

import org.nuswishboard.backend.model.Contact
import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepository : JpaRepository<Contact, Long> {
    fun findByIdeaId(ideaId: Long): Collection<Contact>
}
