package com.kotlinJpaApp.kotlinJpaApplication.entity

class UserRequest(
    val email: String,
    val lastName: String,
    val firstName: String,
    val middleName: String?,
    val phone: String,
) {
    companion object {
        fun of(userFromRequest: UserRequest): User {
            return User(
                null,
                userFromRequest.email,
                userFromRequest.lastName,
                userFromRequest.firstName,
                userFromRequest.middleName,
                userFromRequest.phone
            )
        }
    }
}