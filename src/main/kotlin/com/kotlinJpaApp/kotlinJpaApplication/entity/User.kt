package com.kotlinJpaApp.kotlinJpaApplication.entity

data class User(
    val email: String,
    val secondName: String,
    val firstName: String,
    val patronymic: String?,
    val phone: String
)
