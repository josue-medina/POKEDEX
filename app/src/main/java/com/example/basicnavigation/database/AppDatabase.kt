package com.example.basicnavigation.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 2
const val TABLE_USER = "user"
const val DATABASE_NAME = "myappname.sqlite"

@Database(
    entities = [UserEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)

abstract  class  AppDatabase: RoomDatabase(){
    abstract fun userDao(): UserDao
}