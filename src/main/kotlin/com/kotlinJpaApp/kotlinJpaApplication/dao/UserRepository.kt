package com.kotlinJpaApp.kotlinJpaApplication.dao

import com.kotlinJpaApp.kotlinJpaApplication.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Int> {
}