package com.fandroid.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fandroid.data.local.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userInfoEntity: UserInfoEntity)

    @Query(
        """
            SELECT *
            FROM userinfoentity
        """
    )
    fun getUserInfo(): Flow<UserInfoEntity>
}
