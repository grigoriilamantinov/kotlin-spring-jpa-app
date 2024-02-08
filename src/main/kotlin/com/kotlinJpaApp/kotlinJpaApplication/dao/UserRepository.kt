package com.kotlinJpaApp.kotlinJpaApplication.dao

import com.kotlinJpaApp.kotlinJpaApplication.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Int>
{
    @Query("SELECT u.phone FROM User u")
    fun getPhoneList (): List<String>
}