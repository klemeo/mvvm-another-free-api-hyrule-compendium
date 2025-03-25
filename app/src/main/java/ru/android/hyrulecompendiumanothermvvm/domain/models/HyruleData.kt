package ru.android.hyrulecompendiumanothermvvm.domain.models

import java.io.Serializable

data class HyruleData(
    val id: Int?,
    val category: String?,
    val name: String?,
    val image: String?,
    val description: String?,
    val commonLocations: List<String>?,
    val properties: Properties?,
    val drops: List<String>?,
    val cookingEffect: String?,
    val heartsRecovered: Double?
) : Serializable

class Properties(
    val attack: Int?,
    val defense: Int?,
) : Serializable