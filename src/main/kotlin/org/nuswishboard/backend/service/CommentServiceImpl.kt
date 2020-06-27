package org.nuswishboard.backend.service

import org.nuswishboard.backend.dao.CommentRepository
import org.nuswishboard.backend.dao.IdeaRepository
import org.nuswishboard.backend.model.Comment
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val ideaRepository: IdeaRepository
) : CommentService {
    override fun getAllCommentsByIdeaId(ideaId: Long) = commentRepository.findByIdeaId(ideaId)

    override fun createComment(ideaId: Long, comment: Comment): Comment? =
        ideaRepository.findById(ideaId).map { idea ->
            comment.idea = idea
            return@map commentRepository.save(comment)
        }.orElse(null)

    override fun getComment(id: Long): Comment? = commentRepository.findById(id).orElse(null)

    override fun updateComment(comment: Comment): Comment? =
        commentRepository.findById(comment.id!!).map { existingComment ->
            val updatedComment = existingComment.setText(comment.text)
            return@map commentRepository.save(updatedComment)
        }.orElse(null)

    override fun deleteComment(id: Long): Comment? =
        commentRepository.findById(id).map { existingComment ->
            commentRepository.deleteById(id)
            return@map existingComment
        }.orElse(null)
}
