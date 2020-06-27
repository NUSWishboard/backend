package org.nuswishboard.backend.service

import org.nuswishboard.backend.dao.IdeaRepository
import org.nuswishboard.backend.model.Idea
import org.springframework.stereotype.Service

@Service
class IdeaServiceImpl(private val ideaRepository: IdeaRepository) : IdeaService {
    override fun getAllIdeas(): Collection<Idea> = ideaRepository.findAll()

    override fun createIdea(idea: Idea): Idea =
        ideaRepository.save(Idea(idea = idea.idea, owner = idea.owner, description = idea.description))

    override fun getIdea(id: Long): Idea? = ideaRepository.findById(id).orElse(null)

    override fun updateIdea(idea: Idea): Idea? =
        ideaRepository.findById(idea.id).map { existingIdea ->
            val updatedIdea = existingIdea
                .copy(idea = idea.idea, owner = idea.owner, description = idea.description)
            return@map ideaRepository.save(updatedIdea)
        }.orElse(null)

    override fun deleteIdea(id: Long): Idea? =
        ideaRepository.findById(id).map { existingIdea ->
            ideaRepository.deleteById(id)
            return@map existingIdea
        }.orElse(null)
}
