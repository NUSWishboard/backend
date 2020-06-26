package org.nuswishboard.backend.controller

import io.swagger.annotations.ApiOperation
import org.nuswishboard.backend.model.Idea
import org.nuswishboard.backend.service.IdeaService
import org.nuswishboard.backend.service.LoginService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RouteController(private val ideaService: IdeaService, private val loginService: LoginService) {

    @ApiOperation(value = "Landing page where all the ideas are loaded")
    @GetMapping("/")
    fun home(): Collection<Idea> {
        return ideaService.getAllIdeas()
    }

    @ApiOperation(value = "Login endpoint")
    @PostMapping("/login")
    fun login(@RequestBody token: String) = loginService.loginByToken(token)
}
