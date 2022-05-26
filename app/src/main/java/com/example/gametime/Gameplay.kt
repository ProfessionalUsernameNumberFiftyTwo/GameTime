package com.example.gametime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gameplay(
    var game: String = "default",
    var time: Int = 0,
    var player: String = "name",
    var image: String = "",
    var ownerId: String = ""
) : Parcelable
