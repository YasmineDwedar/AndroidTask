package com.example.androidtask.di.module.app

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.androidtask.R
import com.example.androidtask.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Yasmine on September,2021
 */
@Module
abstract class AppModule {
    companion object {

        @Singleton
        @Provides
        fun provideMoshi(): Moshi =
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()


        @Singleton
        @Provides
        fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
                .build()

        @Singleton
        @Provides
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY }

        @Singleton
        @Provides
        fun provideHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor,
        ): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .callTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build()

        @Singleton
        @Provides
        fun provideRequestOptions(): RequestOptions =
            RequestOptions.placeholderOf(R.drawable.placeholder)
                .error(R.drawable.placeholder).diskCacheStrategy(
                    DiskCacheStrategy.ALL)

        @Singleton
        @Provides
        fun provideGlideInstance(
            application: Application,
            requestOptions: RequestOptions
        ): RequestManager =
            Glide.with(application).setDefaultRequestOptions(requestOptions)

    }


    @Singleton
    @Binds
    abstract fun bindApplicationContext(application: Application): Context


}