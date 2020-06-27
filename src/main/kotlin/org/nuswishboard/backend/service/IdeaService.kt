package org.nuswishboard.backend.service

import org.nuswishboard.backend.model.Idea

interface IdeaService {
    fun getAllIdeas(): Collection<Idea>
    fun createIdea(idea: Idea): Idea
    fun getIdea(id: Long): Idea?
    fun updateIdea(idea: Idea): Idea?
    fun deleteIdea(id: Long): Idea?
}
