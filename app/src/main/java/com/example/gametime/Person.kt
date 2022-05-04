package com.example.gametime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person (
    var name : String = "Default",
    var ownerId : String? = null,
    var objectId : String? = null
    ) : Parcelable