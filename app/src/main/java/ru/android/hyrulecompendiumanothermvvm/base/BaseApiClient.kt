package ru.android.hyrulecompendiumanothermvvm.base

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.android.hyrulecompendiumanothermvvm.BuildConfig
import java.util.concurrent.TimeUnit

open class BaseApiClient<T>(private val classT: Class<T>) {

    companion object{
        const val CONNECTION_TIMEOUT: Long = 180L
        const val READ_TIMEOUT: Long = 180L
        const val WRITE_TIMEOUT: Long = 180L
    }

    open fun getApiClient(): T {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofitBuilder = Retrofit.Builder().apply {
            baseUrl("https://botw-compendium.herokuapp.com/api/v2/")
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
        }


        val retrofit = retrofitBuilder.build()
        return retrofit.create(classT)
    }
}