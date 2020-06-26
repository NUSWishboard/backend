package org.nuswishboard.backend.dao

import org.nuswishboard.backend.model.Idea
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface IdeaRepository : CrudRepository<Idea, Long> {
    fun findById(id: String): Idea?
    fun findAllByOrderByAddedAtDesc(): Array<Idea>
}
