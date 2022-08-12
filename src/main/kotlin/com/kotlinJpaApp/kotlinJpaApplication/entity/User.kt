package com.kotlinJpaApp.kotlinJpaApplication.entity

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.*

@Entity
@Table(name = "users")
@Schema(description = "Entity for user.")
data class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "email") val email: String,
    @Column(name = "second_name") val secondName: String,
    @Column(name = "first_name") val firstName: String,
    @Column(name = "patronymic") val patronymic: String?,
    @Column(name = "phone") val phone: String
)
