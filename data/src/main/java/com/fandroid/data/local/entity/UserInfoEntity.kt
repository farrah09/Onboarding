package com.fandroid.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserInfoEntity(

    val fName: String,
    val lName: String,
    val telephone: String,
    @PrimaryKey val id: Int

)
