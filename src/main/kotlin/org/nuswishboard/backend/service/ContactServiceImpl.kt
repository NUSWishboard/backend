package org.nuswishboard.backend.service

import org.nuswishboard.backend.dao.ContactRepository
import org.nuswishboard.backend.dao.IdeaRepository
import org.nuswishboard.backend.model.Contact
import org.springframework.stereotype.Service

@Service
class ContactServiceImpl(
    private val contactRepository: ContactRepository,
    private val ideaRepository: IdeaRepository
) : ContactService {
    override fun getAllContactsByIdeaId(ideaId: Long) = contactRepository.findByIdeaId(ideaId)

    override fun createContact(ideaId: Long, contact: Contact): Contact? =
        ideaRepository.findById(ideaId).map { idea ->
            contact.idea = idea
            return@map contactRepository.save(contact)
        }.orElse(null)

    override fun getContact(id: Long): Contact? = contactRepository.findById(id).orElse(null)

    override fun updateContact(contact: Contact): Contact? =
        contactRepository.findById(contact.id).map { existingContact ->
            val updatedContact = existingContact.setContact(contact.contact)
            updatedContact.setDescription(contact.description)
            return@map contactRepository.save(updatedContact)
        }.orElse(null)

    override fun deleteContact(id: Long): Contact? =
        contactRepository.findById(id).map { existingContact ->
            contactRepository.deleteById(id)
            return@map existingContact
        }.orElse(null)
}
