package org.nuswishboard.backend.dao

import org.nuswishboard.backend.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByIdeaId(ideaId: Long): Collection<Comment>
}
