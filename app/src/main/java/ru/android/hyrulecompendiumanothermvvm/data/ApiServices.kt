package ru.android.hyrulecompendiumanothermvvm.data

import retrofit2.http.*
import ru.android.hyrulecompendiumanothermvvm.data.models.HyruleInfoDto

interface ApiServices {

    @GET("category/{category}")
    fun getCategory(
        @Path("category") category: String
    ): HyruleInfoDto


}