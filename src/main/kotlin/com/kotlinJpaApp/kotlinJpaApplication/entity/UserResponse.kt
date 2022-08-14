package com.kotlinJpaApp.kotlinJpaApplication.entity


data class UserResponse(
    val id: Int?,
    val email: String,
    val lastName: String,
    val firstName: String,
    val middleName: String?,
    val phone: String,
) {
    companion object {
    fun of(user: User): UserResponse {
        return UserResponse(
            user.id,
            user.email,
            user.lastName,
            user.firstName,
            user.middleName,
            user.phone
        )
    }
}

}
