package com.fandroid.data

import com.fandroid.domain.model.UserInfo

object DataFixtures {

    fun getUserInfoModel() = (
        getUserInfoModel("test", "test", "00000000")
        )

    internal fun getUserInfoModel(fName: String = "fName", lName: String = "lName", telephone: String = "telephone"): UserInfo = UserInfo(
        fName,
        lName,
        telephone,
    )
}
