package com.fandroid.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserCredentialsEntity(

    val email: String,
    val password: String,
    @PrimaryKey val id: Int

)
