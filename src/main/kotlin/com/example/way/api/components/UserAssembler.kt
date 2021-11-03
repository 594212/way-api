package com.example.way.api.components

import com.example.way.api.data.models.User
import com.example.way.api.helpers.objects.UserResponse
import org.springframework.stereotype.Component

@Component
class UserAssembler {
    fun toUserResponse(user: User): UserResponse {
        return UserResponse(
            id = user.id,
            name = user.username,
            accountStatus = user.accountStatus ?: "activated",
            phone = user.phoneNumber ?: "+7(999)-999-99-99"
        )

    }

}