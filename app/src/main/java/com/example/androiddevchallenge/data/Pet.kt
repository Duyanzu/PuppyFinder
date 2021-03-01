package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes

data class Pet(
    val name: String,
    val varieties: String,
    val hobby: String,
    @DrawableRes val avatar: Int
)