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
import com.kotlinJpaApp.kotlinJpaApplication.entity.UserRequest
import com.kotlinJpaApp.kotlinJpaApplication.entity.UserResponse
import com.kotlinJpaApp.kotlinJpaApplication.services.UserService

@WebMvcTest
internal class MainRestControllerTest(@Autowired val mockMvc: MockMvc) {
    @MockkBean
    lateinit var userService: UserService

    private val userResponse = UserResponse(
        1,
        "example@linux.com",
        "Boson",
        "Bob",
        "Diamond",
        "8-900-90-90",
    )

    @Test
    fun getUserById() {
        every { userService.getById(1) } returns userResponse
        mockMvc.perform(get(USER_URL))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.email").value("example@linux.com"))
            .andExpect(jsonPath("$.lastName").value("Boson"))
            .andExpect(jsonPath("$.firstName").value("Bob"))
            .andExpect(jsonPath("$.middleName").value("Diamond"))
            .andExpect(jsonPath("$.phone").value("8-900-90-90"))

    }

    private val userRequest = UserRequest(
        "example@linux.com",
        "Boson",
        "Bob",
        "Diamond",
        "8-900-90-90",
    )
    private val userResponse2 = UserResponse(
        null,
        "example@linux.com",
        "Boson",
        "Bob",
        "Diamond",
        "8-900-90-90",
    )

    @Test
    fun saveUser() {
        val mapper = jacksonObjectMapper()
        every { userService.save(userRequest) } returns userResponse2

        mockMvc.perform(post(USERS_URL)
            .content(mapper.writeValueAsString(userRequest))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    companion object {
        const val USER_URL = "/api/users/1"
        const val USERS_URL = "/api/users/"
    }

}