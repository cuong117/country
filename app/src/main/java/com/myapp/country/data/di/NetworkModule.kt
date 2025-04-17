package com.myapp.country.data.di

import android.util.Log
import com.myapp.country.BuildConfig
import com.myapp.country.convert.Secret
import com.myapp.country.data.dataScource.remote.api.CountryService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val netWorkModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideCountryService(get()) }
}

private fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level =
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.BODY
        }
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

private fun provideRetrofit(client: OkHttpClient): Retrofit {
    Log.v("tag111", "provideRetrofit ${BuildConfig.BASE_URL}")
    return Retrofit.Builder()
        .baseUrl(Secret.decrypt(BuildConfig.BASE_URL))
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideCountryService(retrofit: Retrofit) = retrofit.create(CountryService::class.java)
