package com.example.basicnavigation.database

class User(id: Int, name: String,tipo:String,hp:String,attack:String,special:String,defense:String,defense_special:String,speed:String,weight:String){
                val id = id
                val name= name
                val tipo=tipo
                val hp=hp
                val attack=attack
                val special=special
                val defense=defense
                val defense_special=defense_special
                val speed= speed
                val weight=weight
}

fun User.toEntity() = UserEntity(
    id, name, tipo, hp, attack, special, defense,defense_special,speed,weight
)