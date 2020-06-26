package org.nuswishboard.backend.dao

import org.nuswishboard.backend.model.Idea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IdeaRepository : JpaRepository<Idea, Long>
