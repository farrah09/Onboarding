package com.fandroid.data.mapper

import com.fandroid.data.local.entity.UserCredentialsEntity
import com.fandroid.data.local.entity.UserInfoEntity
import com.fandroid.domain.model.UserCredentials
import com.fandroid.domain.model.UserInfo

fun UserInfo.toUserInfoEntity(): UserInfoEntity {
    return UserInfoEntity(
        fName = fName,
        lName = lName,
        telephone = telephone,
        id = 1
    )
}

fun UserCredentials.toUserCredentialsEntity(): UserCredentialsEntity {
    return UserCredentialsEntity(
        email = email,
        password = password,
        id = 1
    )
}

fun UserCredentialsEntity.toUserCredentials(): UserCredentials {
    return UserCredentials(
        email = email,
        password = password
    )
}

fun UserInfoEntity.toUserInfo(): UserInfo {
    return UserInfo(
        fName = fName,
        lName = lName,
        telephone = telephone
    )
}
