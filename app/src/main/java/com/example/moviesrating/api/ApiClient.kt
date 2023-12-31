package com.example.moviesrating.api

import com.example.moviesrating.screens.utils.Constants.API_KEY
import com.example.moviesrating.screens.utils.Constants.BASEURL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private lateinit var retrofit: Retrofit
    private val interceptor = Interceptor { chain ->
        val url = chain.request().url().newBuilder().addQueryParameter("api_key", API_KEY).build()
        val request = chain.request().newBuilder().url(url).build()
        return@Interceptor chain.proceed(request)
    }
    private val okHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(60, TimeUnit.SECONDS)
            .build()

    fun getClient(): Retrofit {
        retrofit = Retrofit.Builder().baseUrl(BASEURL).client(okHttpClient)
            .addConverterFactory(
            GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

        return retrofit
    }

}