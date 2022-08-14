package com.kotlinJpaApp.kotlinJpaApplication.entity

import io.swagger.v3.oas.annotations.media.Schema
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "users")
@Schema(description = "Entity for user.")
data class User(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    @Column(name = "email") val email: String,
    @Column(name = "last_name") val lastName: String,
    @Column(name = "first_name") val firstName: String,
    @Column(name = "middle_name") val middleName: String?,
    @Column(name = "phone") val phone: String,
)
