package ru.android.hyrulecompendiumanothermvvm.data.models

import com.google.gson.annotations.SerializedName

data class HyruleInfoDto(
    @SerializedName("data")
    val data: List<HyruleDataDto>?
)
