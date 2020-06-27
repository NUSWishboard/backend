package org.nuswishboard.backend.service

import org.nuswishboard.backend.model.Comment

interface CommentService {
    fun getAllCommentsByIdeaId(ideaId: Long): Collection<Comment>
    fun createComment(ideaId: Long, comment: Comment): Comment?
    fun getComment(id: Long): Comment?
    fun updateComment(comment: Comment): Comment?
    fun deleteComment(id: Long): Comment?
}
