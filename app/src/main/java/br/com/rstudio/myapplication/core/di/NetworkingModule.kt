package br.com.rstudio.myapplication.core.di

import br.com.rstudio.myapplication.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkingModule {

    private const val _1MB = 1024 * 1024L

    val module = module {

        single<Moshi> {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        single<HttpLoggingInterceptor> {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        single<Cache> {
            Cache(androidContext().cacheDir, maxSize = (BuildConfig.CACHE_IN_MB * _1MB))
        }

        single<OkHttpClient> {
            OkHttpClient.Builder()
                .cache(get<Cache>())
                .apply {
                    if (BuildConfig.DEBUG) {
                        addInterceptor(get<HttpLoggingInterceptor>())
                    }
                }
                .build()
        }

        single<MoshiConverterFactory> {
            MoshiConverterFactory.create(get<Moshi>())
        }

        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(get<MoshiConverterFactory>())
                .client(get())
                .build()
        }
    }
}