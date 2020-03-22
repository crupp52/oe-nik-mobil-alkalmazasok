package com.crupp52.p02.model

import java.io.Serializable

data class User(
    val name: String,
    val website: String,
    val phoneNumber: String,
    val gender: Int,
    val school: Int
) : Serializable