package org.nuswishboard.backend

import org.nuswishboard.backend.dao.IdeaRepository
import org.nuswishboard.backend.model.Idea
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BackendConfiguration {
    private val logger: Logger = LoggerFactory.getLogger("BackendApplication")

    @Bean
    fun databaseInitializer(ideaRepository: IdeaRepository) = ApplicationRunner {
        logger.info("initializing database")
        ideaRepository.save(Idea("idea", "owner", "desc", 123))
    }
}
