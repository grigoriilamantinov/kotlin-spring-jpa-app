package com.kotlinJpaApp.kotlinJpaApplication.services

import com.kotlinJpaApp.kotlinJpaApplication.entity.UserResponse
import com.kotlinJpaApp.kotlinJpaApplication.entity.UserRequest
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun getById(id: Int): UserResponse

    fun getAll(): List<UserResponse>

    fun save(user: UserRequest): UserResponse

    fun getAllPhones (): List<String>
}