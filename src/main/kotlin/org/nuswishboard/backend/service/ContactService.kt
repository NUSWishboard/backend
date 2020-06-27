package org.nuswishboard.backend.service

import org.nuswishboard.backend.model.Contact

interface ContactService {
    fun getAllContactsByIdeaId(ideaId: Long): Collection<Contact>
    fun createContact(ideaId: Long, contact: Contact): Contact?
    fun getContact(id: Long): Contact?
    fun updateContact(contact: Contact): Contact?
    fun deleteContact(id: Long): Contact?
}
