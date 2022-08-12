package com.kotlinJpaApp.kotlinJpaApplication.services

import com.kotlinJpaApp.kotlinJpaApplication.dao.UserRepository
import com.kotlinJpaApp.kotlinJpaApplication.entity.User
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
): UserService {

    override fun getById(id: Int) = userRepository.getReferenceById(id)

    override fun getAll(): MutableList<User> = userRepository.findAll()

    override fun save(user: User) {
        userRepository.save(user)
    }
}