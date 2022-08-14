package com.kotlinJpaApp.kotlinJpaApplication.services

import com.kotlinJpaApp.kotlinJpaApplication.dao.UserRepository
import com.kotlinJpaApp.kotlinJpaApplication.entity.UserResponse
import com.kotlinJpaApp.kotlinJpaApplication.entity.UserRequest
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository): UserService {

    override fun getById(id: Int): UserResponse {
        return UserResponse.of(userRepository.getReferenceById(id))
    }

    override fun getAll(): List<UserResponse> {
        return userRepository.findAll()
            .map { UserResponse.of(it) }
    }

    override fun save(userFromRequest: UserRequest): UserResponse {
        val userToSave = UserRequest.of(userFromRequest)
        return UserResponse.of(userRepository.save(userToSave))
    }

}