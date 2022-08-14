package com.kotlinJpaApp.kotlinJpaApplication.entity

import org.springframework.web.bind.annotation.PathVariable

data class UserForSave(
    val email: String,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val phone: String,
) {
    companion object {
        fun getUserById(userForSave: UserForSave): User {
            return User (
                0,
                userForSave.email,
                userForSave.lastName,
                userForSave.firstName,
                userForSave.middleName,
                userForSave.phone
            )
        }
    }

}


