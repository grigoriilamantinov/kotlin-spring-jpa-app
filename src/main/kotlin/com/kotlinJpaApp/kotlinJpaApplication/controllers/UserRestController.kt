package com.kotlinJpaApp.kotlinJpaApplication.controllers

import com.kotlinJpaApp.kotlinJpaApplication.entity.UserRequest
import com.kotlinJpaApp.kotlinJpaApplication.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users/")
class UserRestController(
    private val userService: UserService
) {

    @GetMapping("{id}")
    fun getUserById(@PathVariable id: Int) = userService.getById(id)

    @GetMapping
    fun getAllUser() = userService.getAll()

    @PostMapping
    fun saveUser(@RequestBody userRequest: UserRequest) = userService.save(userRequest)

}