package com.daftmobile.a4bhomework5

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import android.support.annotation.ColorInt

@Parcelize
@SuppressLint("ParcelCreator")
data class PokemonItem(val index: String = "",
                       val name: String = "",
                       @ColorInt val backgroundColor: Int = 0): Parcelable

