package com.fandroid.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fandroid.data.local.entity.UserCredentialsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserCredentialsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userCredentialsEntity: UserCredentialsEntity)

    @Query(
        """
            SELECT *
            FROM usercredentialsentity
        """
    )
    fun getUserCredentials(): Flow<UserCredentialsEntity>
}
