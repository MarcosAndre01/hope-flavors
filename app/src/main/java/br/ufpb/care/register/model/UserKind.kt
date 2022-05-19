package br.ufpb.care.register.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class UserKind(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val icon: Int,
)