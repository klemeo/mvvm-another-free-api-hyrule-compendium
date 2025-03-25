package ru.android.hyrulecompendiumanothermvvm.data

import retrofit2.Call
import retrofit2.http.*
import ru.android.hyrulecompendiumanothermvvm.data.models.HyruleInfoDto

interface ApiServices {

    @GET("compendium/category/{category}")
    fun getCompendiumCharacters(
        @Path("category") category: String
    ): Call<HyruleInfoDto>

}