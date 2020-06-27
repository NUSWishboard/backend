package org.nuswishboard.backend.controller

import io.swagger.annotations.ApiOperation
import org.nuswishboard.backend.model.Contact
import org.nuswishboard.backend.service.ContactService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import javax.validation.Valid

@Controller
@RequestMapping("/idea/{ideaId}/contact")
class ContactController(val contactService: ContactService) {

    @ApiOperation(value = "Get all the contacts for the idea")
    @GetMapping("/")
    fun getAllContactsByIdeaId(@PathVariable(value = "ideaId") ideaId: Long): ResponseEntity<Collection<Contact>> =
        ResponseEntity(contactService.getAllContactsByIdeaId(ideaId), HttpStatus.OK)

    @ApiOperation(value = "Create new contact for the idea")
    @PostMapping("/")
    fun createContact(@PathVariable ideaId: Long, @Valid @RequestBody contact: Contact): ResponseEntity<Contact> {
        val contact = contactService.createContact(ideaId, contact) ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        return ResponseEntity(contact, HttpStatus.CREATED)
    }

    @ApiOperation(value = "Get a contact for the idea by contact id")
    @GetMapping("/{contactId}")
    fun getContact(@PathVariable contactId: Long) = ResponseEntity(contactService.getContact(contactId), HttpStatus.OK)

    @ApiOperation(value = "Update a contact for the idea by contact id")
    @PutMapping("/{contactId}")
    fun updateContact(@PathVariable contactId: Long, @RequestBody contact: Contact): ResponseEntity<Contact> {
        val contact = contactService.updateContact(contact) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(contact, HttpStatus.OK)
    }

    @ApiOperation(value = "Delete a contact for the idea by contact id")
    @DeleteMapping("/{contactId}")
    fun deleteContact(@PathVariable contactId: Long): ResponseEntity<Contact> {
        val contact = contactService.deleteContact(contactId) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(contact, HttpStatus.OK)
    }
}
