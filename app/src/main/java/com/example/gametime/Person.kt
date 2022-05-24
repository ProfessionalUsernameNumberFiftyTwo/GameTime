package com.example.gametime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Person (
    var name : String = "Default",
    var ownerId : String? = null,
    var objectId : String? = null,
    var gameplay : List<Gameplay> = listOf(),
    var friendIds: List<String> = listOf()
    ) : Parcelable