package com.kotlinJpaApp.kotlinJpaApplication.controllers

import com.kotlinJpaApp.kotlinJpaApplication.entity.User
import com.kotlinJpaApp.kotlinJpaApplication.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class MainRestController(
    private val userService: UserService
) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int) = userService.getById(id)

    @GetMapping()
    fun getAllUser() = userService.getAll()

    @PostMapping()
    fun saveUser(@RequestBody user: User) = userService.save(user)

}