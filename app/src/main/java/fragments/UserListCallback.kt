package fragments

import com.example.basicnavigation.database.User

interface UserListCallback {
    fun onClick(user:User)
}