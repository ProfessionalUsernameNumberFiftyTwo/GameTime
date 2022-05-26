package com.example.gametime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Friend(
    var name : String = "Default",
    var objectId : String? = null,
) : Parcelable {}
