package com.example.basicnavigation.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USER)
data class UserEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val tipo: String,
    val hp:String,
    val attack:String,
    val special:String,
    val defense:String,
    val defense_special: String,
    val speed: String,
    val weight: String
)

fun UserEntity.toUser() = User (
    id, name, tipo, hp, attack, special,defense,defense_special,speed,weight
)
