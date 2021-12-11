package com.example.basicnavigation.database

import androidx.room.*

@Dao
interface UserDao {
    @Delete
    fun delete(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun save(user: UserEntity)

    @Query("SELECT * FROM $TABLE_USER")
    fun getUsersFromDatabase(): List<UserEntity>

}