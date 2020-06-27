package org.nuswishboard.backend.controller

import io.swagger.annotations.ApiOperation
import org.nuswishboard.backend.model.Idea
import org.nuswishboard.backend.service.IdeaService
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
@RequestMapping("/idea")
class IdeaController(val ideaService: IdeaService) {

    @ApiOperation(value = "Create new idea")
    @PostMapping("/")
    fun createIdea(@Valid @RequestBody idea: Idea): ResponseEntity<Idea> =
        ResponseEntity(ideaService.createIdea(idea), HttpStatus.CREATED)

    @ApiOperation(value = "Get an idea by ID")
    @GetMapping("/{id}")
    fun getIdea(@PathVariable id: String): ResponseEntity<Idea> {
        val idea = ideaService.getIdea(id.toLong()) ?: return ResponseEntity.notFound().build()
        return ResponseEntity(idea, HttpStatus.OK)
    }

    @ApiOperation(value = "Update an idea by ID")
    @PutMapping("/{id}")
    fun updateIdea(@PathVariable id: String, @Valid @RequestBody idea: Idea): ResponseEntity<Idea> =
        ResponseEntity(ideaService.updateIdea(idea), HttpStatus.OK)

    @ApiOperation(value = "Get an idea by ID")
    @DeleteMapping("/{id}")
    fun deleteIdea(@PathVariable id: Long): ResponseEntity<Idea> {
        val idea = ideaService.deleteIdea(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity(idea, HttpStatus.OK)
    }
}
