package org.nuswishboard.backend.service

import org.nuswishboard.backend.model.Idea

interface IdeaService {
    fun getAllIdeas(): Collection<Idea>
    fun createIdea(idea: String, owner: String, description: String?): Idea
    fun getIdea(id: Long): Idea?
    fun updateIdea(id: Long, idea: String, owner: String, description: String?): Idea
    fun deleteIdea(id: Long): Idea?
}
