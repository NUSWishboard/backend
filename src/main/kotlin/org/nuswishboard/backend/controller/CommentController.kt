package org.nuswishboard.backend.controller

import io.swagger.annotations.ApiOperation
import org.nuswishboard.backend.model.Comment
import org.nuswishboard.backend.service.CommentService
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
@RequestMapping("/idea/{ideaId}/comment")
class CommentController(val commentService: CommentService) {

    @ApiOperation(value = "Get all the comments for the idea")
    @GetMapping("/")
    fun getAllCommentsByIdeaId(@PathVariable(value = "ideaId") ideaId: Long): ResponseEntity<Collection<Comment>> =
        ResponseEntity(commentService.getAllCommentsByIdeaId(ideaId), HttpStatus.OK)

    @ApiOperation(value = "Create new comment for the idea")
    @PostMapping("/")
    fun createComment(@PathVariable ideaId: Long, @Valid @RequestBody comment: Comment): ResponseEntity<Comment> {
        val comment = commentService.createComment(ideaId, comment) ?: return ResponseEntity(HttpStatus.BAD_REQUEST)
        return ResponseEntity(comment, HttpStatus.CREATED)
    }

    @ApiOperation(value = "Get a comment for the idea by comment id")
    @GetMapping("/{commentId}")
    fun getComment(@PathVariable commentId: Long) = ResponseEntity(commentService.getComment(commentId), HttpStatus.OK)

    @ApiOperation(value = "Update a comment for the idea by comment id")
    @PutMapping("/{commentId}")
    fun updateComment(@PathVariable commentId: Long, @RequestBody comment: Comment): ResponseEntity<Comment> {
        val comment = commentService.updateComment(comment) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(comment, HttpStatus.OK)
    }

    @ApiOperation(value = "Delete a comment for the idea by comment id")
    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long): ResponseEntity<Comment> {
        val comment = commentService.deleteComment(commentId) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(comment, HttpStatus.OK)
    }
}
