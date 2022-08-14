package com.kotlinJpaApp.kotlinJpaApplication.controllers

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kotlinJpaApp.kotlinJpaApplication.entity.User
import com.kotlinJpaApp.kotlinJpaApplication.services.UserService

@WebMvcTest
internal class MainRestControllerTest(@Autowired val mockMvc: MockMvc) {
    @MockkBean
    lateinit var userService: UserService

    private val user = User(
        1,
        "example@ya.com",
        "Boson",
        "Bob",
        "Diamond",
        "8-900-90-90"
    )

    @Test
    fun getUserById() {
        every { userService.getById(1) } returns user

        mockMvc.perform(get(USER_URL))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.email").value("example@ya.com"))
            .andExpect(jsonPath("$.lastName").value("Boson"))
            .andExpect(jsonPath("$.firstName").value("Bob"))
            .andExpect(jsonPath("$.middleName").value("Diamond"))
            .andExpect(jsonPath("$.phone").value("8-900-90-90"))

    }

    @Test
    fun saveUser() {
        val mapper = jacksonObjectMapper()
        every { userService.save(user) } returns user
        mockMvc.perform(post(USERS_URL)
            .content(mapper.writeValueAsString(user))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    companion object {
        const val USER_URL = "/api/users/1"
        const val USERS_URL = "/api/users/"
    }

}