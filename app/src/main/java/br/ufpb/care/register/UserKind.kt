package br.ufpb.care.register

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class UserKind(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val icon: Int,
)