package com.kotlinJpaApp.kotlinJpaApplication.services

import com.kotlinJpaApp.kotlinJpaApplication.entity.User

interface UserService {
    fun getById(id: Int): User

    fun getAll(): List<User>

    fun save(user: User)
}