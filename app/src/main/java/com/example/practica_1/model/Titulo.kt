package com.example.practica_1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Titulo(
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int
)