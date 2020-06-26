package org.nuswishboard.backend.service

import org.nuswishboard.backend.model.Idea
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class IdeaServiceImpl : IdeaService {
    private val ideaRepo = mutableMapOf<Long, Idea>()

    override fun getAllIdeas(): Collection<Idea> = ideaRepo.values

    override fun createIdea(idea: String, owner: String, description: String?): Idea {
        val uuid = UUID.randomUUID().leastSignificantBits
        val newIdea = Idea(idea, owner, description, uuid)
        ideaRepo[uuid] = newIdea
        return newIdea
    }

    override fun getIdea(id: Long): Idea? = ideaRepo[id]

    override fun updateIdea(id: Long, idea: String, owner: String, description: String?): Idea {
        var existingIdea: Idea? = ideaRepo[id] ?: return Idea(idea, owner, description, id)
        existingIdea!!.idea = idea
        existingIdea.owner = owner
        existingIdea.description = description
        existingIdea.updatedAt = LocalDateTime.now()
        return existingIdea
    }

    override fun deleteIdea(id: Long): Idea? = ideaRepo.remove(id)
}
